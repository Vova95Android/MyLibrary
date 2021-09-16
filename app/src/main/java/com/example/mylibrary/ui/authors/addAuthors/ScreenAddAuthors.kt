package com.example.mylibrary.ui.authors.addAuthors

import com.example.mylibrary.R
import com.example.mylibrary.navigation.Screen

class ScreenAddAuthors : Screen() {

    override val container: Int = R.id.author_container

    override val tag: String = AddAuthorsFragment::class.java.simpleName

    override fun getFragment() = AddAuthorsFragment.newInstance()
}
