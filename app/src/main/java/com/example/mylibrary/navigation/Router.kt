package com.example.mylibrary.navigation

import androidx.fragment.app.FragmentManager

interface Router {
    fun attach(fragmentManager: FragmentManager)
    fun detach()
    fun replace(screen: Screen, animate: Boolean = true)
    fun pop()
    fun popAll()
    fun popTo(screen: Screen)
}
