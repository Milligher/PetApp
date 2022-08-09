package com.milligher.petapp.presentation.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.milligher.petapp.domain.useCase.GetAllAnimeUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val getAllAnimeUseCase: GetAllAnimeUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getAllAnimeUseCase = getAllAnimeUseCase
        ) as T
    }


}