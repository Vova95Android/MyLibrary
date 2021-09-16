package com.example.mylibrary.ui.books.addBook.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.addBook.AddBookResult
import com.example.mylibrary.ui.books.addBook.AddBookState
import com.example.mylibrary.ui.model.AuthorUI

class AddBookResultReducer : Reducer<AddBookResult, AddBookState> {
    override fun invoke(result: AddBookResult, state: AddBookState): AddBookState {
        return when (result) {
            is AddBookResult.AddBookAuthorsLoadError -> state.copy(isLoading = false)
            is AddBookResult.AddBookAuthorsLoadSuccess -> state.copy(
                isLoading = false,
                authors = result.authors.map { AuthorUI.fromModel(it) }
            )
            is AddBookResult.SaveNewBookError -> state.copy(isLoading = false)
            is AddBookResult.SaveNewBookSuccess -> state.copy(isLoading = false)
        }
    }
}
