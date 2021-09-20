package com.example.mylibrary.ui.authors.detailAuthor

import android.os.Bundle
import android.view.View
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentDetailAuthorBinding
import com.example.mylibrary.ui.authors.addAuthors.adapter.GenresAdapter
import com.example.mylibrary.ui.authors.addAuthors.adapter.GenresItem

class DetailAuthorFragment : BaseFragment<DetailAuthorViewModel, FragmentDetailAuthorBinding>() {

    private val adapter = GenresAdapter {}

    override fun getParameters(): Any {
        return requireArguments().getString(AUTHOR_ID) ?: ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listGanres.adapter = adapter
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            val authorItem = state.authorItem
            if (authorItem != null) {
                with(binding) {
                    textFirstnameItem.text = authorItem.fistName
                    textLastnameItem.text = authorItem.lastName
                    textDayOfBirdItem.text = authorItem.dateOfBirth
                    adapter.submitList(authorItem.genres.map { GenresItem(it) })
                }
            }
        }
    }

    companion object {

        private const val AUTHOR_ID = "AUTHOR_ID"

        fun newInstance(authorId: String) = DetailAuthorFragment().apply {
            arguments = Bundle().apply {
                putString(AUTHOR_ID, authorId)
            }
        }
    }
}
