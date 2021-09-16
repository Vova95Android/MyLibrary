package com.example.mylibrary.ui.books.booksList

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.books.addBook.ScreenAddBook
import com.example.mylibrary.ui.books.booksList.reducer.BookListActionReducer
import com.example.mylibrary.ui.books.booksList.reducer.BookListResultReducer

class BookListViewModel(
    useCaseSet: Set<UseCase<BookListAction, BookListState, BookListResult>>,
    router: Router
) : BaseViewModel<BookListAction, BookListState, BookListResult>(
    actionReducer = BookListActionReducer(),
    resultReducer = BookListResultReducer(),
    useCaseSet = useCaseSet,
    initialState = BookListState(),
    router = router
) {

    fun loadBookList() {
        action(BookListAction.GetBookList)
    }

    fun toAddBook() {
        router.replace(ScreenAddBook())
    }
}
