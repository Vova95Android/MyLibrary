package com.example.mylibrary.ui.books.detailBook

import com.example.mylibrary.ui.model.AuthorUI
import com.example.mylibrary.ui.model.BookUI

data class DetailBookState(
    val isLoading: Boolean = false,
    val bookItem: BookUI? = null,
    val bookAuthors: List<AuthorUI> = emptyList()
)
