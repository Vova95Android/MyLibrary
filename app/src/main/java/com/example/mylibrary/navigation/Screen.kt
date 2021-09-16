package com.example.mylibrary.navigation

import androidx.fragment.app.Fragment

abstract class Screen {

    abstract val container: Int

    open val addToBackStack: Boolean = true

    abstract val tag: String

    abstract fun getFragment(): Fragment
}