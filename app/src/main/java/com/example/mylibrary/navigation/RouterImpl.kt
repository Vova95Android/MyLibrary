package com.example.mylibrary.navigation

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class RouterImpl : Router {

    private var fragmentManager: FragmentManager? = null

    override fun replace(screen: Screen, animate: Boolean) {
        val manager = fragmentManager ?: return
        val fragment = screen.getFragment()

        if (fragment is DialogFragment) {
            fragment.show(manager, screen.tag)
        } else {
            manager.beginTransaction()
                .replace(screen.container, fragment, screen.tag)
                .apply {
                    if (screen.addToBackStack) {
                        addToBackStack(screen.tag)
                    }
                }
                .commit()
        }
    }

    override fun popTo(screen: Screen) {
        val manager = fragmentManager ?: return
        manager.popBackStackImmediate(screen.tag, 0)
    }

    override fun pop() {
        fragmentManager?.popBackStackImmediate()
    }

    override fun popAll() {
        fragmentManager?.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun attach(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    override fun detach() {
        this.fragmentManager = null
    }
}
