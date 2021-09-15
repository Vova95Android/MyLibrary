package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import com.example.mylibrary.ui.model.AuthorUI

sealed class AuthorSelectAction {
    data class AuthorClicks(
        val author: AuthorUI,
        val select: Boolean
    ) : AuthorSelectAction()

    object LoadAuthors : AuthorSelectAction()
}