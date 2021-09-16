package com.example.mylibrary.ui.books.addBook

import com.example.mylibrary.data.model.AuthorModel

sealed class AddBookResult {
    data class AddBookAuthorsLoadSuccess(val authors: List<AuthorModel>) : AddBookResult()
    data class AddBookAuthorsLoadError(val message: String?) : AddBookResult()
    object SaveNewBookSuccess : AddBookResult()
    data class SaveNewBookError(
        val message: String? = "",
        val titleIsEmpty: Boolean = false,
        val descriptionsIsEmpty: Boolean = false,
        val authorsIsEmpty: Boolean = false
    ) : AddBookResult()
}
