package com.milligher.petapp.presentation.fragments.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class SavedViewModelFactory @Inject constructor(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SavedViewModelFactory(
        ) as T
    }


}