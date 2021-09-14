package com.example.mylibrary.ui.addAuthors.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.addAuthors.AddAuthorResult
import com.example.mylibrary.ui.addAuthors.AddAuthorState


class AddAuthorsResultReducer : Reducer<AddAuthorResult, AddAuthorState> {
    override fun invoke(result: AddAuthorResult, state: AddAuthorState): AddAuthorState {
        return when (result) {
            is AddAuthorResult.AuthorSaveError -> {
                state.copy(
                    firstNameIsEmpty = result.firstNameIsEmpty,
                    lastNameIsEmpty = result.lastNameIsEmpty,
                    dateOfBirthIsEmpty = result.dateOfBirthIsEmpty
                )
            }
            is AddAuthorResult.AuthorSaveSuccess -> state.copy(isLoading = false)
        }
    }
}
