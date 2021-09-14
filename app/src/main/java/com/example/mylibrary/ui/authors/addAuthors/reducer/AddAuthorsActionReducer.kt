package com.example.mylibrary.ui.authors.addAuthors.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorAction
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorState

class AddAuthorsActionReducer : Reducer<AddAuthorAction, AddAuthorState> {
    override fun invoke(action: AddAuthorAction, state: AddAuthorState): AddAuthorState {
        return when (action) {
            is AddAuthorAction.DateOfBirthChanged -> {
                state.copy(
                    dateOfBirth = action.dateOfBirth,
                    validateError = state.validateError.copy(dateOfBirthIsEmpty = false)
                )
            }
            is AddAuthorAction.FirstNameChanged -> {
                state.copy(
                    fistName = action.firstName,
                    validateError = state.validateError.copy(firstNameIsEmpty = false)
                )
            }
            is AddAuthorAction.LastNameChanged -> {
                state.copy(
                    lastName = action.lastName,
                    validateError = state.validateError.copy(lastNameIsEmpty = false)
                )
            }
            is AddAuthorAction.SaveAuthor -> state.copy(isLoading = true)
        }
    }
}
