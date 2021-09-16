package com.example.mylibrary.ui.books.addBook.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.addBook.AddBookAction
import com.example.mylibrary.ui.books.addBook.AddBookState

class AddBookActionReducer : Reducer<AddBookAction, AddBookState> {
    override fun invoke(action: AddBookAction, state: AddBookState): AddBookState {
        return when (action) {
            is AddBookAction.SetBookAuthorsId -> state.copy(
                validateError = state.validateError.copy(authorsIsEmpty = action.authors.isEmpty())
            )
            is AddBookAction.SetBookDescriptions -> state.copy(
                bookDescriptions = action.descriptions,
                validateError = state.validateError.copy(descriptionsIsEmpty = false)
            )
            is AddBookAction.SetBookName -> state.copy(
                bookName = action.name,
                validateError = state.validateError.copy(titleIsEmpty = false)
            )
            is AddBookAction.SetBookTitle -> state.copy(bookTitle = action.title)
            is AddBookAction.AddNewBook -> state
        }
    }
}
