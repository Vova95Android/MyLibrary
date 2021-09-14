package com.example.mylibrary.ui.authors.addAuthors

data class AddAuthorState(
    val isLoading: Boolean = false,
    val fistName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val validateError: AddAuthorValidateError = AddAuthorValidateError(),
    val authorSaveSuccess: Boolean = false
)

data class AddAuthorValidateError(
    val firstNameIsEmpty: Boolean = false,
    val lastNameIsEmpty: Boolean = false,
    val dateOfBirthIsEmpty: Boolean = false
)
