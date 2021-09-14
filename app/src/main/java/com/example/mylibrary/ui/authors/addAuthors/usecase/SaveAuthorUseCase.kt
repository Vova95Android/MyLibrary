package com.example.mylibrary.ui.authors.addAuthors.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.model.AuthorModel
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorAction
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorResult
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorState
import java.lang.Exception

class SaveAuthorUseCase(
    private val authorRepository: AuthorRepository
) : UseCase<AddAuthorAction, AddAuthorState, AddAuthorResult>() {
    override fun map(action: AddAuthorAction, state: AddAuthorState): AddAuthorResult {
        return try {
            if (state.fistName.isNotEmpty() && state.lastName.isNotEmpty() && state.dateOfBirth.isNotEmpty()) {
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
            } else {
                AddAuthorResult.AuthorSaveError(
                    firstNameIsEmpty = state.fistName.isEmpty(),
                    lastNameIsEmpty = state.lastName.isEmpty(),
                    dateOfBirthIsEmpty = state.dateOfBirth.isEmpty()
                )
            }
        } catch (e: Exception) {
            AddAuthorResult.AuthorSaveError(e.message)
        }
    }

    override fun canHandle(action: AddAuthorAction): Boolean {
        return action is AddAuthorAction.SaveAuthor
    }
}
