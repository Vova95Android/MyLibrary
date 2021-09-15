package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectResult
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectState
import com.example.mylibrary.ui.model.AuthorUI

class AuthorSelectResultReducer : Reducer<AuthorSelectResult, AuthorSelectState> {
    override fun invoke(result: AuthorSelectResult, state: AuthorSelectState): AuthorSelectState {
        return when(result){
            is AuthorSelectResult.AuthorSelectLoadError -> state.copy(isLoading = false)
            is AuthorSelectResult.AuthorSelectLoadSuccess -> state.copy(
                isLoading = false,
                authors = result.authors.map { AuthorUI.fromModel(it) }
            )
        }
    }
}
