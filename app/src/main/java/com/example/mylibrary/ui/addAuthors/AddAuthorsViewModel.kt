package com.example.mylibrary.ui.addAuthors

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.base.mvi.UseCase

class AddAuthorsViewModel(
    useCaseSet: Set<UseCase<AddAuthorAction, AddAuthorState, AddAuthorResult>>
) : BaseViewModel<AddAuthorAction, AddAuthorState, AddAuthorResult>(
    actionReducer = AddAuthorsActionReducer(),
    resultReducer = AddAuthorsResultReducer(),
    useCaseSet = useCaseSet,
    initialState = AddAuthorState()
) {
    fun setDateOfBirth(year: Int, month: Int, dayOfMonth: Int) {
        action(
            AddAuthorAction.DateOfBirthChanged("$dayOfMonth.$month.$year")
        )
    }

    fun firstNameChanged(name: String) {
        action(
            AddAuthorAction.FirstNameChanged(name)
        )
    }

    fun lastNameChanged(name: String) {
        action(
            AddAuthorAction.LastNameChanged(name)
        )
    }

    fun saveAuthor() {
        action(AddAuthorAction.SaveAuthor)
    }
}

class AddAuthorsActionReducer : Reducer<AddAuthorAction, AddAuthorState> {
    override fun invoke(action: AddAuthorAction, state: AddAuthorState): AddAuthorState {
        return when (action) {
            is AddAuthorAction.DateOfBirthChanged -> state.copy(dateOfBirth = action.dateOfBirth)
            is AddAuthorAction.FirstNameChanged -> state.copy(fistName = action.firstName)
            is AddAuthorAction.LastNameChanged -> state.copy(lastName = action.lastName)
            AddAuthorAction.SaveAuthor -> state
        }
    }
}

class AddAuthorsResultReducer : Reducer<AddAuthorResult, AddAuthorState> {
    override fun invoke(result: AddAuthorResult, state: AddAuthorState): AddAuthorState {
        return state
    }
}
