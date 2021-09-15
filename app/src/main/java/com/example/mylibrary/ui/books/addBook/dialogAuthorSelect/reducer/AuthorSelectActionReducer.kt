package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectAction
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectState

class AuthorSelectActionReducer : Reducer<AuthorSelectAction, AuthorSelectState> {
    override fun invoke(action: AuthorSelectAction, state: AuthorSelectState): AuthorSelectState {
        return when(action){
            is AuthorSelectAction.LoadAuthors -> state.copy(isLoading = true)
            is AuthorSelectAction.AuthorClicks -> state.copy(
                authors = state.authors.map {
                    if (it.id == action.author.id) it.copy(isChecked = !it.isChecked)
                    else it
                }
            )
        }
    }
}
