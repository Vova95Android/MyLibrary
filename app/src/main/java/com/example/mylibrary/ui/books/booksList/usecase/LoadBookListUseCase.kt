package com.example.mylibrary.ui.books.booksList.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.repository.BookRepository
import com.example.mylibrary.ui.books.booksList.BookListAction
import com.example.mylibrary.ui.books.booksList.BookListResult
import com.example.mylibrary.ui.books.booksList.BookListState

class LoadBookListUseCase(
    private val bookRepository: BookRepository
) : UseCase<BookListAction, BookListState, BookListResult>() {

    override fun map(action: BookListAction, state: BookListState): BookListResult {
        return try {
            val list = bookRepository.getBookList()
            BookListResult.BookListLoadSuccess(list)
        } catch (e: Exception) {
            BookListResult.BookListLoadError(e.message)
        }
    }

    override fun canHandle(action: BookListAction): Boolean {
        return action is BookListAction.GetBookList
    }
}
