package com.example.mylibrary.ui.books.addBook.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.addBook.AddBookResult
import com.example.mylibrary.ui.books.addBook.AddBookState

class AddBookResultReducer : Reducer<AddBookResult, AddBookState> {
    override fun invoke(result: AddBookResult, state: AddBookState): AddBookState {
        return state
    }
}
