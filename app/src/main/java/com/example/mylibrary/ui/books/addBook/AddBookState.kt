package com.example.mylibrary.ui.books.addBook

import com.example.mylibrary.ui.model.AuthorUI

data class AddBookState(
    val isLoading: Boolean = false,
    val authors: List<AuthorUI> = emptyList(),
    val bookName: String = "",
    val bookDescriptions: String = "",
    val bookTitle: Int? = null,
    val addBookSuccess: Boolean = false
)
