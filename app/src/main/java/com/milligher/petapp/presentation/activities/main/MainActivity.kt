package com.milligher.petapp.presentation.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.milligher.petapp.App
import com.milligher.petapp.R
import com.milligher.petapp.databinding.ActivityMainBinding
import com.milligher.petapp.databinding.FragmentMainBinding
import com.milligher.petapp.presentation.activities.main.adapter.ViewPagerAdapter
import com.milligher.petapp.presentation.fragments.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        (applicationContext as App).appComponent.inject(this)

        mBinding.mainViewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(mBinding.tabLayout, mBinding.mainViewPager) { tab, position ->
            when(position){
                0 -> tab.setIcon(R.drawable.home)
                1 -> tab.setIcon(R.drawable.save)
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}