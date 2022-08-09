package com.milligher.petapp.presentation.activities.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.milligher.petapp.presentation.fragments.main.MainFragment
import com.milligher.petapp.presentation.fragments.saved.SavedFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainFragment()
            else -> SavedFragment()
        }
    }

}