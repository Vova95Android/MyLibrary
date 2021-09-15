package com.example.mylibrary.ui.books.addBook

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.books.addBook.reducer.AddBookActionReducer
import com.example.mylibrary.ui.books.addBook.reducer.AddBookResultReducer

class AddBookViewModel (
    useCaseSet: Set<UseCase<AddBookAction, AddBookState, AddBookResult>>,
    router: Router
): BaseViewModel<AddBookAction, AddBookState, AddBookResult>(
    actionReducer = AddBookActionReducer(),
    resultReducer = AddBookResultReducer(),
    useCaseSet = useCaseSet,
    initialState = AddBookState(),
    router = router
) {

}