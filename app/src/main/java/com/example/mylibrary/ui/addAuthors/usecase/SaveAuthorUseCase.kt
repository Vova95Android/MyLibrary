package com.example.mylibrary.ui.addAuthors.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.model.AuthorModel
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.ui.addAuthors.AddAuthorAction
import com.example.mylibrary.ui.addAuthors.AddAuthorResult
import com.example.mylibrary.ui.addAuthors.AddAuthorState
import java.lang.Exception

class SaveAuthorUseCase(
    private val authorRepository: AuthorRepository
) : UseCase<AddAuthorAction, AddAuthorState, AddAuthorResult>() {
    override fun map(action: AddAuthorAction, state: AddAuthorState): AddAuthorResult {
        return try {
            authorRepository.saveNewAuthor(
                AuthorModel(
                    fistName = state.fistName,
                    lastName = state.lastName,
                    dateOfBirth = state.dateOfBirth,
                    genres = emptyList(),
                    bookIds = emptyList()
                )
            )
            AddAuthorResult.AuthorSaveSuccess
        } catch (e: Exception) {
            AddAuthorResult.AuthorSaveError(e.message)
        }
    }

    override fun canHandle(action: AddAuthorAction): Boolean {
        return action is AddAuthorAction.SaveAuthor
    }
}
