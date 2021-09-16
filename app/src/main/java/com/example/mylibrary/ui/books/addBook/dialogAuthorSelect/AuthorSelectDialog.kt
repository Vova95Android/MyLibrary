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
            authorList.adapter = adapter
        }
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.authors)
        }
    }

    override fun onDestroy() {
        val bundle = Bundle()
        bundle.putStringArray(
            AUTHOR_SELECT_DIALOG_LIST,
            viewModel.stateLiveData.value?.authors?.filter { it.isChecked }?.map { it.id }
                ?.toTypedArray() ?: emptyArray()
        )
        requireActivity().supportFragmentManager.setFragmentResult(AUTHOR_SELECT_DIALOG, bundle)
        super.onDestroy()
    }

    companion object {
        const val AUTHOR_SELECT_DIALOG = "AuthorSelectDialog"
        const val AUTHOR_SELECT_DIALOG_LIST = "AuthorSelectDialogList"
        fun newInstance() = AuthorSelectDialog()
    }
}
