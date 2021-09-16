package com.example.mylibrary.ui.start.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mylibrary.ui.start.BackPressed

class StartViewPagerAdapter(
    fragment: Fragment,
    private val fragments: List<BackPressed>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getCurrentFragment(currentPositions: Int): BackPressed = fragments[currentPositions]
}
