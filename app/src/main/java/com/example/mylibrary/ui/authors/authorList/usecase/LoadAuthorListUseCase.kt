package com.example.mylibrary.ui.authors.authorList.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.ui.authors.authorList.AuthorListAction
import com.example.mylibrary.ui.authors.authorList.AuthorListResult
import com.example.mylibrary.ui.authors.authorList.AuthorListState
import com.example.mylibrary.ui.authors.model.AuthorUI

class LoadAuthorListUseCase(
    private val authorRepository: AuthorRepository
): UseCase<AuthorListAction, AuthorListState, AuthorListResult>() {

    override fun map(action: AuthorListAction, state: AuthorListState): AuthorListResult {
        return try {
            val list = authorRepository.getAuthorList()
            AuthorListResult.AuthorListLoadSuccess(
                list.map { AuthorUI.fromModel(it) }
            )
        } catch (e: Exception){
            AuthorListResult.AuthorListLoadError(e.message)
        }
    }

    override fun canHandle(action: AuthorListAction): Boolean {
       return action is AuthorListAction.LoadAuthors
    }
}