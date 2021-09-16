package com.example.mylibrary.ui.start.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylibrary.databinding.FragmentAuthorBinding
import com.example.mylibrary.di.authorsRouter
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.start.BackPressed
import org.koin.android.ext.android.inject

class AuthorFragment : BackPressed() {

    private val authorRouter by inject<Router>(authorsRouter())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAuthorBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authorRouter.attach(childFragmentManager)
    }

    override fun onDestroy() {
        authorRouter.detach()
        super.onDestroy()
    }

    override fun onBackPressed(): Boolean {
        return if (childFragmentManager.backStackEntryCount > 0) {
            authorRouter.pop()
            false
        } else {
            true
        }
    }
}
