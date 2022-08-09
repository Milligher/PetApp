package com.milligher.petapp.presentation.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milligher.petapp.App
import com.milligher.petapp.databinding.FragmentMainBinding
import com.milligher.petapp.presentation.fragments.main.adapter.AnimeRecyclerAdapter
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val mBinding get() = _binding

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        (context?.applicationContext as App).appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        mBinding.animeRecycler.layoutManager = GridLayoutManager(context, 2)
        val adapter = AnimeRecyclerAdapter()
        mBinding.animeRecycler.adapter = adapter
        viewModel.getAllItems()
        viewModel.getLiveDataItems().observe(viewLifecycleOwner) { list ->
            mBinding.allAnimeProgressBar.visibility = View.GONE
            adapter.setAnimeList(list = list)
        }

        return mBinding.root
    }

}