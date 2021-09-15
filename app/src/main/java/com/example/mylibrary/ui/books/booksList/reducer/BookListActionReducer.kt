package com.example.mylibrary.ui.books.booksList.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.booksList.BookListAction
import com.example.mylibrary.ui.books.booksList.BookListState

class BookListActionReducer : Reducer<BookListAction, BookListState> {
    override fun invoke(action: BookListAction, state: BookListState): BookListState {
        return when(action){
            BookListAction.GetBookList -> state.copy(isLoading = true)
        }
    }
}
