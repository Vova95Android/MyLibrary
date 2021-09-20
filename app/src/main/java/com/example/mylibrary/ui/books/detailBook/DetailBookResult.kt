package com.example.mylibrary.ui.books.detailBook

import com.example.mylibrary.data.model.AuthorModel
import com.example.mylibrary.data.model.BookModel

sealed class DetailBookResult {

    data class LoadBookSuccess(
        val bookItem: BookModel,
        val bookAuthors: List<AuthorModel>
    ) : DetailBookResult()

    data class LoadBookError(
        val message: String?
    ) : DetailBookResult()
}
