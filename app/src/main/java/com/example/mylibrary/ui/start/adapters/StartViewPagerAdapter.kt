package com.example.mylibrary.ui.start.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mylibrary.ui.start.BackPressed

class StartViewPagerAdapter(
    fragment: Fragment,
    private val fragments: List<BackPressed>
) : FragmentStateAdapter(fragment) {
    private var currentPositions = 0

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        currentPositions = position
        return fragments[position]
    }

    fun getCurrentFragment(): BackPressed {
        return fragments[currentPositions]
    }
}
