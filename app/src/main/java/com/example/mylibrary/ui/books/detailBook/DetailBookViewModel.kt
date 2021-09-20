package com.example.mylibrary.ui.books.detailBook

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.books.detailBook.reducer.DetailBookActionReducer
import com.example.mylibrary.ui.books.detailBook.reducer.DetailBookResultReducer

class DetailBookViewModel(
    useCaseSet: Set<UseCase<DetailBookAction, DetailBookState, DetailBookResult>>,
    router: Router,
    bookId: String
) : BaseViewModel<DetailBookAction, DetailBookState, DetailBookResult>(
    actionReducer = DetailBookActionReducer(),
    resultReducer = DetailBookResultReducer(),
    useCaseSet = useCaseSet,
    initialState = DetailBookState(),
    router = router
) {

    init {
        action(DetailBookAction.GetCurrentBook(bookId))
    }
}
