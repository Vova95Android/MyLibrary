package com.example.mylibrary.ui.addAuthors.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.addAuthors.AddAuthorAction
import com.example.mylibrary.ui.addAuthors.AddAuthorState

class AddAuthorsActionReducer : Reducer<AddAuthorAction, AddAuthorState> {
    override fun invoke(action: AddAuthorAction, state: AddAuthorState): AddAuthorState {
        return when (action) {
            is AddAuthorAction.DateOfBirthChanged -> {
                state.copy(
                    dateOfBirth = action.dateOfBirth,
                    dateOfBirthIsEmpty = false
                )
            }
            is AddAuthorAction.FirstNameChanged -> {
                state.copy(
                    fistName = action.firstName,
                    firstNameIsEmpty = false
                )
            }
            is AddAuthorAction.LastNameChanged -> {
                state.copy(
                    lastName = action.lastName,
                    lastNameIsEmpty = false
                )
            }
            is AddAuthorAction.SaveAuthor -> state.copy(isLoading = true)
        }
    }
}
