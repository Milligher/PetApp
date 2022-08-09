package com.milligher.petapp.domain.repository

import com.milligher.petapp.domain.model.api.Anime
import io.reactivex.Single
import retrofit2.Response

interface RetrofitRepository {
    fun getAllAnime(): Single<List<Anime>>?

    fun getAnimeDetail(id: Int): Single<Anime>?
}