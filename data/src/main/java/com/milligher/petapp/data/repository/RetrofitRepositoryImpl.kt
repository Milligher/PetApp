package com.milligher.petapp.data.repository

import com.milligher.petapp.domain.model.api.Anime
import com.milligher.petapp.domain.repository.RetrofitRepository
import com.milligher.petapp.domain.repository.server.ServerCommunicator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RetrofitRepositoryImpl(private val serverCommunicator: ServerCommunicator) :
    RetrofitRepository {

    override fun getAllAnime(): Single<List<Anime>>? {
        return serverCommunicator.getAllAnime()
            .flatMap {
                val allAnimeList: MutableList<Anime> = mutableListOf()
                allAnimeList.addAll(it.body()!!.data)
                val responseList: List<Anime> = allAnimeList
                Single.just(responseList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getAnimeDetail(id: Int): Single<Anime>? {
        return serverCommunicator.getAnimeFromId(id = id)
            .flatMap {
                val anime: Anime = it.body()!!.data
                Single.just(anime)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}