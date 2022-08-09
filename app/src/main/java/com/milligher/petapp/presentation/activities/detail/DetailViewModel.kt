package com.milligher.petapp.presentation.activities.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.milligher.petapp.domain.model.api.Anime
import com.milligher.petapp.domain.useCase.GetAnimeDetailUseCase

class DetailViewModel(private val getAnimeDetailUseCase: GetAnimeDetailUseCase): ViewModel() {

    private val liveDataItem = MutableLiveData<Anime>()

    private var animeId: Int = 0

    @SuppressLint("CheckResult")
    fun getItem() {
        if (liveDataItem.value == null)
            getAnimeDetailUseCase.execute(id = animeId)?.subscribe { list -> liveDataItem.value = list }
        else
            Log.d("MYTAG", "AAAAAAAAAAAA")
    }

    fun getLiveDataItem(): LiveData<Anime> {
        return liveDataItem
    }

    fun setAnimeId(id: Int) {
        animeId = id
    }
}