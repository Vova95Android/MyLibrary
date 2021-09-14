package com.example.mylibrary.navigation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class RouterImpl : Router {

    private var fragmentManager: FragmentManager? = null

    private val lifeCycleCallbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
            Log.d("Router", "onFragmentCreated ${f.tag}, ${f.hashCode()}")
        }

        override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
            Log.d("Router", "onFragmentDestroyed ${f.tag}, ${f.hashCode()}")
        }

        override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
            Log.d("Router", "onFragmentViewCreated ${f.tag}, ${f.hashCode()}")
        }

        override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
            Log.d("Router", "onFragmentViewDestroyed ${f.tag}, ${f.hashCode()}")
        }
    }

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
        fragmentManager.registerFragmentLifecycleCallbacks(lifeCycleCallbacks, false)
    }

    override fun detach() {
        fragmentManager?.unregisterFragmentLifecycleCallbacks(lifeCycleCallbacks)
        this.fragmentManager = null
    }
}
