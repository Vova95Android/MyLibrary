package com.example.mylibrary.ui.addAuthors

sealed class AddAuthorResult {

    object AuthorSaveSuccess : AddAuthorResult()

    data class AuthorSaveError(
        val message: String?
    ) : AddAuthorResult()
}
