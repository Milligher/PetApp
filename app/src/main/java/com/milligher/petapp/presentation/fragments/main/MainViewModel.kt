package com.milligher.petapp.presentation.fragments.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.milligher.petapp.domain.model.api.Anime
import com.milligher.petapp.domain.useCase.GetAllAnimeUseCase

class MainViewModel(private val getAllAnimeUseCase: GetAllAnimeUseCase): ViewModel() {

    private val liveDataItems = MutableLiveData<List<Anime>>()

    @SuppressLint("CheckResult")
    fun getAllItems() {
        getAllAnimeUseCase.execute()?.subscribe { list -> liveDataItems.value = list }
    }

    fun getLiveDataItems(): LiveData<List<Anime>> {
        return liveDataItems
    }

}