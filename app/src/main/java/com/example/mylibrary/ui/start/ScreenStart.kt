package com.example.mylibrary.ui.start

import com.example.mylibrary.navigation.Screen

class ScreenStart : Screen() {

    override val tag: String = StartFragment::class.java.simpleName

    override fun getFragment() = StartFragment.newInstance()
}