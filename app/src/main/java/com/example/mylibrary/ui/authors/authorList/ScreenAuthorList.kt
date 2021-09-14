package com.example.mylibrary.ui.authors.authorList

import com.example.mylibrary.navigation.Screen

class ScreenAuthorList : Screen() {

    override val tag: String = AuthorListFragment::class.java.simpleName

    override fun getFragment() = AuthorListFragment.newInstance()
}
