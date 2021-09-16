package com.example.mylibrary.ui.start.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylibrary.databinding.FragmentBookBinding
import com.example.mylibrary.di.booksRouter
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.start.BackPressed
import org.koin.android.ext.android.inject

class BookFragment : BackPressed() {

    private val booksRouter by inject<Router>(booksRouter())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBookBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        booksRouter.attach(childFragmentManager)
    }

    override fun onDestroy() {
        booksRouter.detach()
        super.onDestroy()
    }

    override fun onBackPressed(): Boolean {
        return if (childFragmentManager.backStackEntryCount > 0) {
            booksRouter.pop()
            false
        } else {
            true
        }
    }
}