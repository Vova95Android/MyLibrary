package com.example.mylibrary.ui.authors.authorList

import com.example.mylibrary.ui.authors.model.AuthorUI

sealed class AuthorListResult {

    data class AuthorListLoadSuccess(
        val authors: List<AuthorUI>
    ) : AuthorListResult()

    data class AuthorListLoadError(
        val message: String?
    ) : AuthorListResult()
}
