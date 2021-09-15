package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import android.os.Bundle
import android.view.View
import com.example.mylibrary.base.BaseBottomSheetDialog
import com.example.mylibrary.databinding.DialogAuthorSelectBinding
import com.example.mylibrary.ui.authors.authorList.adapter.AuthorListAdapter

class AuthorSelectDialog :
    BaseBottomSheetDialog<AuthorSelectViewModel, DialogAuthorSelectBinding>() {

    private val adapter = AuthorListAdapter(
        {

        }, { author, isSelect ->
            viewModel.authorClick(author, isSelect)
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->

        }
    }

    override fun onDestroy() {
        val bundle = Bundle()
        bundle.putStringArray(
            "dsg",
            viewModel.stateLiveData.value?.authors?.map { it.id }?.toTypedArray() ?: emptyArray()
        )
        requireActivity().supportFragmentManager.setFragmentResult("sdfgh", bundle)
        super.onDestroy()
    }
}