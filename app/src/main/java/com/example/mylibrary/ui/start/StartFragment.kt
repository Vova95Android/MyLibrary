package com.example.mylibrary.ui.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mylibrary.R
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentStartBinding
import com.example.mylibrary.ui.authors.authorList.AuthorListFragment
import com.example.mylibrary.ui.books.booksList.BookListFragment
import com.example.mylibrary.ui.start.adapters.AuthorFragment
import com.example.mylibrary.ui.start.adapters.BookFragment
import com.example.mylibrary.ui.start.adapters.StartViewPagerAdapter

class StartFragment : BaseFragment<StartViewModel, FragmentStartBinding>() {

    private val viewPagerAdapter by lazy {
        StartViewPagerAdapter(
            this,
            listOf(
                BookFragment(),
                AuthorFragment()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startViewPager.adapter = viewPagerAdapter
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->

        }
    }

    override fun onBackPressed(): Boolean {
        val fragment = viewPagerAdapter.getCurrentFragment(binding.startViewPager.currentItem)
        return fragment.onBackPressed()
    }
}

abstract class BackPressed : Fragment() {
    abstract fun onBackPressed(): Boolean
}
