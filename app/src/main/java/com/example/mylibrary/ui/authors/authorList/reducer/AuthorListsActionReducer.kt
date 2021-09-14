package com.example.mylibrary.ui.authors.authorList.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.authorList.AuthorListAction
import com.example.mylibrary.ui.authors.authorList.AuthorListState

class AuthorListsActionReducer : Reducer<AuthorListAction, AuthorListState> {
    override fun invoke(action: AuthorListAction, state: AuthorListState): AuthorListState {
        return state
    }
}
