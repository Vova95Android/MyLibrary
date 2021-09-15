package com.example.mylibrary.ui.start

import android.os.Bundle
import android.view.View
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentStartBinding
import com.example.mylibrary.ui.authors.authorList.AuthorListFragment
import com.example.mylibrary.ui.books.booksList.BookListFragment
import com.example.mylibrary.ui.start.adapters.StartViewPagerAdapter

class StartFragment : BaseFragment<StartViewModel, FragmentStartBinding>() {

    private val viewPagerAdapter by lazy {
        StartViewPagerAdapter(this,
        listOf(
            BookListFragment(),
            AuthorListFragment()
        ))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startViewPager.adapter = viewPagerAdapter
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->

        }
    }

    companion object{
        fun newInstance() = StartFragment()
    }
}