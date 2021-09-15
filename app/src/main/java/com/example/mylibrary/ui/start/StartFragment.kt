package com.example.mylibrary.ui.start

import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentStartBinding
import com.example.mylibrary.ui.start.adapters.StartViewPagerAdapter

class StartFragment : BaseFragment<StartViewModel, FragmentStartBinding>() {

    private var viewPagerAdapter = lazy {
        StartViewPagerAdapter(this, emptyList())
    }


    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->

        }
    }
}