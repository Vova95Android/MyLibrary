package com.example.mylibrary.ui.books.detailBook

sealed class DetailBookAction {

    data class GetCurrentBook(
        val bookId: String
    ) : DetailBookAction()
}
