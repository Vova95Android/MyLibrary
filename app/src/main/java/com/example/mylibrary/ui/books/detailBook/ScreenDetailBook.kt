package com.example.mylibrary.ui.books.detailBook

import com.example.mylibrary.R
import com.example.mylibrary.navigation.Screen

class ScreenDetailBook(private val bookId: String) : Screen() {

    override val container: Int = R.id.book_container

    override val tag: String = DetailBookFragment::class.java.simpleName

    override fun getFragment() = DetailBookFragment.newInstance(bookId)
}
