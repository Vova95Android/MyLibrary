package com.example.mylibrary.ui.books.detailBook

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.mylibrary.R
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentDetailBookBinding
import com.example.mylibrary.ui.authors.authorList.adapter.AuthorListAdapter
import org.koin.core.parameter.DefinitionParameters
import org.koin.core.parameter.ParametersDefinition

class DetailBookFragment : BaseFragment<DetailBookViewModel, FragmentDetailBookBinding>() {

    override fun getParameters(): Any {
        return requireArguments().getString(BOOK_ID) ?: ""
    }

    private val adapter = AuthorListAdapter({})

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            bookAuthorListItem.adapter = adapter
            bookTitleItem.setOnClickListener {
                animateToRating()
            }
            bookRatingItem.setOnClickListener {
                animateToTitle()
            }
        }
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                adapter.submitList(state.bookAuthors)
                val bookItem = state.bookItem
                if (bookItem != null) {
                    bookNameItem.text = bookItem.title
                    bookDescriptionsItemText.text = bookItem.descriptions
                    bookTitleItem.setImageResource(bookItem.titleIcon)
                    bookRatingItem.text = bookItem.rating.toString()
                }
            }
        }
    }

    private fun animateToRating() {
        with(binding) {
            animateHorizontal(bookRatingItem, 0f, 90f, 500)
            animateHorizontal(bookTitleItem, 0f, 90f, 500) {
                bookTitleItem.setImageResource(R.color.color_rating)
                bookTitleItem.isClickable = false
                bookRatingItem.isVisible = true
                animateHorizontal(bookTitleItem, -90f, 0f, 500)
                animateHorizontal(bookRatingItem, -90f, 0f, 500)
            }
        }
    }

    private fun animateToTitle() {
        with(binding) {
            animateHorizontal(bookRatingItem, 0f, -90f, 500)
            animateHorizontal(bookTitleItem, 0f, -90f, 500) {
                bookTitleItem.setImageResource(
                    viewModel.stateLiveData.value?.bookItem?.titleIcon
                        ?: R.drawable.book_title_1
                )
                bookTitleItem.isClickable = true
                bookRatingItem.isVisible = false
                animateHorizontal(bookTitleItem, 90f, 0f, 500)
            }
        }
    }

    private fun animateHorizontal(
        view: View,
        rotationYStart: Float,
        rotationYEnd: Float,
        duration: Long,
        withEndAction: (() -> Unit)? = null
    ) {
        view.rotationY = rotationYStart
        view.animate()
            .withLayer()
            .rotationY(rotationYEnd)
            .setDuration(duration)
            .withEndAction { withEndAction?.invoke() }
            .start()
    }

    companion object {

        private const val BOOK_ID = "BOOK_ID"

        fun newInstance(bookId: String) = DetailBookFragment().apply {
            arguments = Bundle().apply {
                putString(BOOK_ID, bookId)
            }
        }
    }
}
