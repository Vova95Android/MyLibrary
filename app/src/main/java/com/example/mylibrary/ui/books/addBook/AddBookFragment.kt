package com.example.mylibrary.ui.books.addBook

import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentAddBookBinding

class AddBookFragment: BaseFragment<AddBookViewModel, FragmentAddBookBinding>() {

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner){state->

        }
    }

    companion object {
        fun newInstance() = AddBookFragment()
    }
}