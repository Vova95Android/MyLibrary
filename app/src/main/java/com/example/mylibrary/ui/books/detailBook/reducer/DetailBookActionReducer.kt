package com.example.mylibrary.ui.books.detailBook.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.books.detailBook.DetailBookAction
import com.example.mylibrary.ui.books.detailBook.DetailBookState

class DetailBookActionReducer : Reducer<DetailBookAction, DetailBookState> {
    override fun invoke(action: DetailBookAction, state: DetailBookState): DetailBookState {
        return state
    }
}
