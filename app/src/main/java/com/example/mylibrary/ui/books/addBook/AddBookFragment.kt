package com.example.mylibrary.ui.books.addBook

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.example.mylibrary.R
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentAddBookBinding
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectDialog
import java.util.*
import kotlin.random.Random

class AddBookFragment : BaseFragment<AddBookViewModel, FragmentAddBookBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            bookBookName.doOnTextChanged { text, _, _, _ ->
                if (!text.isNullOrEmpty()) viewModel.setBookName(text.toString())
            }
            bookDescriptions.doOnTextChanged { text, _, _, _ ->
                if (!text.isNullOrEmpty()) viewModel.setBookDescriptions(text.toString())
            }
            bookBookAuthors.setOnClickListener {
                viewModel.toSelectAuthors()
            }
        }
        viewModel.setBookTitle(getRandomTitle())
        fragmentResultListener()
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                var authors = ""
                state.authors.forEach { authors += "${it.lastName} ${it.fistName}\r\n" }
                bookBookAuthors.text = authors
                bookTitle.setImageResource(state.bookTitle?: R.drawable.book_title_1)
            }
        }
    }

    private fun fragmentResultListener() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            AuthorSelectDialog.AUTHOR_SELECT_DIALOG,
            viewLifecycleOwner
        ) { _, result ->
            val list = result.getStringArray(AuthorSelectDialog.AUTHOR_SELECT_DIALOG_LIST)?.toList()
                ?: emptyList()
            viewModel.setBookAuthorsId(list)
        }
    }

    companion object {
        fun newInstance() = AddBookFragment()
    }

    private fun getRandomTitle(): Int{
        return when(Random(Calendar.getInstance().timeInMillis).nextInt(1,5)){
            1-> R.drawable.book_title_1
            2-> R.drawable.book_title_2
            3-> R.drawable.book_title_3
            4-> R.drawable.book_title_4
            else-> R.drawable.book_title_5
        }
    }
}