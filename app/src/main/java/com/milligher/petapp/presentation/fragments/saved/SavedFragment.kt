package com.milligher.petapp.presentation.fragments.saved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.milligher.petapp.databinding.FragmentSavedBinding

class SavedFragment : Fragment() {

    private lateinit var _binding: FragmentSavedBinding
    private val mBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedBinding.inflate(layoutInflater, container, false)

        return mBinding.root
    }

}