package com.example.mylibrary.ui.books.addBook.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.ui.books.addBook.AddBookAction
import com.example.mylibrary.ui.books.addBook.AddBookResult
import com.example.mylibrary.ui.books.addBook.AddBookState

class AddBookLoadAuthorListUseCase(
    private val authorRepository: AuthorRepository
) : UseCase<AddBookAction, AddBookState, AddBookResult>() {

    override fun map(action: AddBookAction, state: AddBookState): AddBookResult {
        return try {
            val ids =
                if (action is AddBookAction.SetBookAuthorsId) action.authors
                else emptyList()
            val list = authorRepository.getAuthorList().filter { author ->
                val find = ids.firstOrNull { it == author.id }
                find != null
            }
            AddBookResult.AddBookAuthorsLoadSuccess(list)
        } catch (e: Exception) {
            AddBookResult.AddBookAuthorsLoadError(e.message)
        }
    }

    override fun canHandle(action: AddBookAction): Boolean {
        return action is AddBookAction.SetBookAuthorsId
    }
}