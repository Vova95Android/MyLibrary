package com.example.mylibrary.ui.books.booksList

import com.example.mylibrary.data.model.BookModel

sealed class BookListResult {

    data class BookListLoadSuccess(
        val books: List<BookModel>
    ) : BookListResult()

    data class BookListLoadError(
        val message: String?
    ) : BookListResult()
}
