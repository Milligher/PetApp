package com.milligher.petapp.presentation.activities.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.milligher.petapp.domain.useCase.GetAnimeDetailUseCase
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(val getAnimeDetailUseCase: GetAnimeDetailUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(
            getAnimeDetailUseCase = getAnimeDetailUseCase
        ) as T
    }
}
