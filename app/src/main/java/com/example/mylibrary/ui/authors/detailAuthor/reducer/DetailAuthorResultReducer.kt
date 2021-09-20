package com.example.mylibrary.ui.authors.detailAuthor.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorResult
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorState
import com.example.mylibrary.ui.model.AuthorUI

class DetailAuthorResultReducer : Reducer<DetailAuthorResult, DetailAuthorState> {
    override fun invoke(result: DetailAuthorResult, state: DetailAuthorState): DetailAuthorState {
        return when (result) {
            is DetailAuthorResult.LoadAuthorError -> state
            is DetailAuthorResult.LoadAuthorSuccess -> state.copy(
                authorItem = AuthorUI.fromModel(result.authorItem)
            )
        }
    }
}
