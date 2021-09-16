package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import com.example.mylibrary.R
import com.example.mylibrary.navigation.Screen

class ScreenAuthorSelect : Screen() {

    override val container: Int = R.id.book_container

    override val tag: String = AuthorSelectDialog::class.java.simpleName

    override fun getFragment() = AuthorSelectDialog.newInstance()
}
