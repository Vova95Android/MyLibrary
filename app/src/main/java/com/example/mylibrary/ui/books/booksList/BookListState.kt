package com.example.mylibrary.ui.books.booksList

import com.example.mylibrary.ui.model.BookUI

data class BookListState(
    val isLoading: Boolean = false,
    val books: List<BookUI> = emptyList(),
    val filterAuthorsId: List<String> = emptyList()
)
