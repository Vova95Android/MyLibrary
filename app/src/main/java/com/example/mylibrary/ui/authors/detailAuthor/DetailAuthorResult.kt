package com.example.mylibrary.ui.authors.detailAuthor

import com.example.mylibrary.data.model.AuthorModel

sealed class DetailAuthorResult {

    data class LoadAuthorSuccess(
        val authorItem: AuthorModel
    ) : DetailAuthorResult()

    data class LoadAuthorError(
        val message: String?
    ) : DetailAuthorResult()
}
