package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import com.example.mylibrary.ui.model.AuthorUI

data class AuthorSelectState(
    val isLoading: Boolean = false,
    val authors: List<AuthorUI> = emptyList()
)