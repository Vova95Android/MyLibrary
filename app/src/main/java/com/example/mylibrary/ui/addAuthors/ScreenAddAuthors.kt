package com.example.mylibrary.ui.addAuthors

import com.example.mylibrary.navigation.Screen

class ScreenAddAuthors : Screen() {

    override val tag: String = AddAuthorsFragment::class.java.simpleName

    override fun getFragment() = AddAuthorsFragment.newInstance()
}
