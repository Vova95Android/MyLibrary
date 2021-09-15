package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectAction
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectResult
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectState

class AuthorSelectLoadAuthorSelectUseCase(
    private val authorRepository: AuthorRepository
): UseCase<AuthorSelectAction, AuthorSelectState, AuthorSelectResult>() {

    override fun map(action: AuthorSelectAction, state: AuthorSelectState): AuthorSelectResult {
        return try {
            val list = authorRepository.getAuthorList()
            AuthorSelectResult.AuthorSelectLoadSuccess(
                list
            )
        } catch (e: Exception){
            AuthorSelectResult.AuthorSelectLoadError(e.message)
        }
    }

    override fun canHandle(action: AuthorSelectAction): Boolean {
       return action is AuthorSelectAction.LoadAuthors
    }
}