package com.example.mylibrary.ui.books.booksList

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.example.mylibrary.R
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentBookListBinding
import com.example.mylibrary.di.booksRouter
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectDialog
import com.example.mylibrary.ui.books.booksList.adapter.BookListAdapter
import org.koin.android.ext.android.inject

class BookListFragment : BaseFragment<BookListViewModel, FragmentBookListBinding>() {

    private val adapter = BookListAdapter {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            addBookButton.setOnClickListener {
                viewModel.toAddBook()
            }
            booksRecycler.adapter = adapter
            buttonBooksFilter.setOnClickListener {
                viewModel.toSelectAuthors()
            }
        }
        fragmentResultListener()
    }

    private fun fragmentResultListener() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            AuthorSelectDialog.AUTHOR_SELECT_DIALOG,
            viewLifecycleOwner
        ) { _, result ->
            val list = result.getStringArray(AuthorSelectDialog.AUTHOR_SELECT_DIALOG_LIST)?.toList()
                ?: emptyList()
            viewModel.filterAsAuthorId(list)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadBookList()
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            val listBooks =
                if (state.filterAuthorsId.isNotEmpty()) {
                    state.books.filter { book ->
                        var find = false
                        state.filterAuthorsId.forEach { authors ->
                            find = !book.authorIds.find { authors == it }.isNullOrEmpty()
                            if (find) return@forEach
                        }
                        find
                    }
                } else state.books
            adapter.submitList(listBooks)
        }
    }
}
