package com.example.mylibrary.ui.books.detailBook.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.data.repository.BookRepository
import com.example.mylibrary.ui.books.detailBook.DetailBookAction
import com.example.mylibrary.ui.books.detailBook.DetailBookResult
import com.example.mylibrary.ui.books.detailBook.DetailBookState

class LoadCurrentBookUseCase(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository
) : UseCase<DetailBookAction, DetailBookState, DetailBookResult>() {

    override fun map(action: DetailBookAction, state: DetailBookState): DetailBookResult {
        return try {
            val action = action as DetailBookAction.GetCurrentBook
            val bookItem = bookRepository.getBookFromId(action.bookId)
            if (bookItem != null) {
                val authors = authorRepository.getAuthorList().filter {
                    bookItem.authorIds.find { authorId -> authorId == it.id } != null
                }
                DetailBookResult.LoadBookSuccess(
                    bookItem = bookItem,
                    bookAuthors = authors
                )
            } else {
                DetailBookResult.LoadBookError("")
            }
        } catch (e: Exception) {
            DetailBookResult.LoadBookError(e.message)
        }
    }

    override fun canHandle(action: DetailBookAction): Boolean {
        return action is DetailBookAction.GetCurrentBook
    }
}
