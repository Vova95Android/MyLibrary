package com.example.mylibrary.ui.authors.detailAuthor

import com.example.mylibrary.R
import com.example.mylibrary.navigation.Screen

class ScreenDetailAuthor(private val authorId: String) : Screen() {

    override val container: Int = R.id.author_container

    override val tag: String = DetailAuthorFragment::class.java.simpleName

    override fun getFragment() = DetailAuthorFragment.newInstance(authorId)
}
