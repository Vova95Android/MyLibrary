package com.example.mylibrary.ui.addAuthors

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.ui.addAuthors.reducer.AddAuthorsActionReducer
import com.example.mylibrary.ui.addAuthors.reducer.AddAuthorsResultReducer

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
