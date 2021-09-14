package com.example.mylibrary.ui.authors.addAuthors

sealed class AddAuthorAction {

    data class FirstNameChanged(
        val firstName: String
    ) : AddAuthorAction()

    data class LastNameChanged(
        val lastName: String
    ) : AddAuthorAction()

    data class DateOfBirthChanged(
        val dateOfBirth: String
    ) : AddAuthorAction()

    object SaveAuthor : AddAuthorAction()
}
