package com.example.mylibrary.ui.authors.addAuthors

import com.example.mylibrary.ui.authors.addAuthors.adapter.GenresItem

data class AddAuthorState(
    val isLoading: Boolean = false,
    val fistName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val validateError: AddAuthorValidateError = AddAuthorValidateError(),
    val authorSaveSuccess: Boolean = false,
    val genres: List<GenresItem> = emptyList()
)

data class AddAuthorValidateError(
    val firstNameIsEmpty: Boolean = false,
    val lastNameIsEmpty: Boolean = false,
    val dateOfBirthIsEmpty: Boolean = false
)
