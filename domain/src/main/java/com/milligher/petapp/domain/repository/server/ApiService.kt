package com.milligher.petapp.domain.repository.server

import com.milligher.petapp.domain.model.api.AllAnimeResponse
import com.milligher.petapp.domain.model.api.AnimeResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("anime")
    fun getAllAnime(): Single<Response<AllAnimeResponse>>

    @GET("anime/{id}/full")
    fun getAnimeFromId(@Path("id") id: Int?): Single<Response<AnimeResponse>>
}