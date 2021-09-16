package com.example.mylibrary.ui.books.booksList.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.model.BookUI
import com.example.mylibrary.ui.books.booksList.BookListResult
import com.example.mylibrary.ui.books.booksList.BookListState

class BookListResultReducer : Reducer<BookListResult, BookListState> {
    override fun invoke(result: BookListResult, state: BookListState): BookListState {
        return when (result) {
            is BookListResult.BookListLoadError -> state.copy(isLoading = false)
            is BookListResult.BookListLoadSuccess -> state.copy(
                isLoading = false,
                books = result.books.map { BookUI.fromModel(it) }
            )
        }
    }
}
