package com.example.mylibrary.ui.books.booksList

sealed class BookListAction {
    data class FilterBooks(val authors: List<String>) : BookListAction()

    object GetBookList : BookListAction()
}
