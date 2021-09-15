package com.example.mylibrary.ui.books.booksList

import android.os.Bundle
import android.view.View
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentBookListBinding
import com.example.mylibrary.ui.books.booksList.adapter.BookListAdapter

class BookListFragment: BaseFragment<BookListViewModel, FragmentBookListBinding>() {

    private val adapter = BookListAdapter{

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            addBookButton.setOnClickListener {
                viewModel.toAddBook()
            }
            booksRecycler.adapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadBookList()
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner){state->
            adapter.submitList(state.books)
        }
    }
}