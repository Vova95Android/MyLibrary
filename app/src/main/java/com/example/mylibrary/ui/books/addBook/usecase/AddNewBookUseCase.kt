package com.example.mylibrary.ui.books.addBook.usecase

import com.example.mylibrary.R
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.model.BookModel
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.data.repository.BookRepository
import com.example.mylibrary.ui.books.addBook.AddBookAction
import com.example.mylibrary.ui.books.addBook.AddBookResult
import com.example.mylibrary.ui.books.addBook.AddBookState
import java.util.*
import kotlin.random.Random

class AddNewBookUseCase(
    private val bookRepository: BookRepository
) : UseCase<AddBookAction, AddBookState, AddBookResult>() {

    override fun map(action: AddBookAction, state: AddBookState): AddBookResult {
        return try {
            val bookModel = BookModel(
                title = state.bookName,
                descriptions = state.bookDescriptions,
                titleIcon = state.bookTitle ?: R.drawable.book_title_1,
                authorIds = state.authors.map { it.id },
                genres = emptyList(),
                rating = Random(Calendar.getInstance().timeInMillis).nextInt(0, 5)
            )
            bookRepository.saveNewBook(bookModel)
            AddBookResult.SaveNewBookSuccess
        } catch (e: Exception) {
            AddBookResult.SaveNewBookError(e.message)
        }
    }

    override fun canHandle(action: AddBookAction): Boolean {
        return action is AddBookAction.AddNewBook
    }
}
