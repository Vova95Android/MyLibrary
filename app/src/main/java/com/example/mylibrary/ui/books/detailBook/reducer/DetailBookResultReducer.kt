package com.example.mylibrary.ui.books.detailBook.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.detailBook.DetailBookResult
import com.example.mylibrary.ui.books.detailBook.DetailBookState
import com.example.mylibrary.ui.model.AuthorUI
import com.example.mylibrary.ui.model.BookUI

class DetailBookResultReducer : Reducer<DetailBookResult, DetailBookState> {
    override fun invoke(result: DetailBookResult, state: DetailBookState): DetailBookState {
        return when (result) {
            is DetailBookResult.LoadBookError -> state
            is DetailBookResult.LoadBookSuccess -> state.copy(
                bookItem = BookUI.fromModel(result.bookItem),
                bookAuthors = result.bookAuthors.map { AuthorUI.fromModel(it) }
            )
        }
    }
}
