package com.example.mylibrary.ui.addAuthors

data class AddAuthorState(
    val isLoading: Boolean = false,
    val fistName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = ""
)
