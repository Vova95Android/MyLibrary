package com.example.mylibrary.ui.authors.authorList.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.authorList.AuthorListResult
import com.example.mylibrary.ui.authors.authorList.AuthorListState


class AuthorListsResultReducer : Reducer<AuthorListResult, AuthorListState> {
    override fun invoke(result: AuthorListResult, state: AuthorListState): AuthorListState {
        return when(result){
            is AuthorListResult.AuthorListLoadError -> state
            is AuthorListResult.AuthorListLoadSuccess -> state.copy(
                authors = result.authors
            )
        }
    }
}
