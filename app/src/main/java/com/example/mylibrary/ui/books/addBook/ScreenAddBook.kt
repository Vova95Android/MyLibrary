package com.example.mylibrary.ui.books.addBook

import com.example.mylibrary.R
import com.example.mylibrary.navigation.Screen

class ScreenAddBook: Screen() {

    override val container: Int = R.id.book_container

    override val tag: String = AddBookFragment::class.java.simpleName

    override fun getFragment() = AddBookFragment.newInstance()
}
