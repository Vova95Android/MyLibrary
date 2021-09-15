package com.example.mylibrary.ui.books.addBook

import com.example.mylibrary.navigation.Screen

class ScreenAddBook: Screen() {

    override val tag: String = AddBookFragment::class.java.simpleName

    override fun getFragment() = AddBookFragment.newInstance()
}