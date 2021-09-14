package com.example.mylibrary.ui.authors.addAuthors

sealed class AddAuthorResult {

    object AuthorSaveSuccess : AddAuthorResult()

    data class AuthorSaveError(
        val message: String? = "",
        val firstNameIsEmpty: Boolean = false,
        val lastNameIsEmpty: Boolean = false,
        val dateOfBirthIsEmpty: Boolean = false
    ) : AddAuthorResult()
}
