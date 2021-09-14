package com.example.mylibrary.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.mylibrary.R

abstract class Screen {

    @IdRes
    open val container: Int = R.id.fragmentContainer

    open val addToBackStack: Boolean = true

    abstract val tag: String

    abstract fun getFragment(): Fragment
}