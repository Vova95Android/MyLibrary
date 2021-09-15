package com.example.mylibrary.ui.authors.authorList

import android.os.Bundle
import android.view.View
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentAuthorListBinding
import com.example.mylibrary.ui.authors.authorList.adapter.AuthorListAdapter

class AuthorListFragment : BaseFragment<AuthorListViewModel, FragmentAuthorListBinding>() {

    private val adapter = AuthorListAdapter(
        clickListener = {item->

        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAddNewAuthor.setOnClickListener {
            viewModel.toAddAuthors()
        }
        binding.authorList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadAuthorList()
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.authors)
        }
    }

    companion object {
        fun newInstance() = AuthorListFragment()
    }
}
