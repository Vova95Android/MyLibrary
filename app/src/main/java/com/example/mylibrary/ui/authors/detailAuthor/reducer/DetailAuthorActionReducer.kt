package com.example.mylibrary.ui.authors.detailAuthor.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorAction
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorState

class DetailAuthorActionReducer : Reducer<DetailAuthorAction, DetailAuthorState> {
    override fun invoke(action: DetailAuthorAction, state: DetailAuthorState): DetailAuthorState {
        return state
    }
}
