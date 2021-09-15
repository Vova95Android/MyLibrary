package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import com.example.mylibrary.data.model.AuthorModel

sealed class AuthorSelectResult {

    data class AuthorSelectLoadSuccess(
        val authors: List<AuthorModel>
    ): AuthorSelectResult()

    data class AuthorSelectLoadError(
        val message: String?
    ): AuthorSelectResult()
}