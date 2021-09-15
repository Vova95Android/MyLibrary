package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import com.example.mylibrary.navigation.Screen

class ScreenAuthorSelect: Screen() {

    override val tag: String = AuthorSelectDialog::class.java.simpleName

    override fun getFragment() = AuthorSelectDialog.newInstance()
}