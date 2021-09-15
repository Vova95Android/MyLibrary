package com.example.mylibrary.ui.books.addBook.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.addBook.AddBookAction
import com.example.mylibrary.ui.books.addBook.AddBookState

class AddBookActionReducer : Reducer<AddBookAction, AddBookState> {
    override fun invoke(action: AddBookAction, state: AddBookState): AddBookState {
        return state
    }
}
