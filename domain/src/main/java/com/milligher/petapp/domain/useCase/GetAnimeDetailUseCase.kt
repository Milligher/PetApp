package com.milligher.petapp.domain.useCase

import com.milligher.petapp.domain.model.api.Anime
import com.milligher.petapp.domain.repository.RetrofitRepository
import io.reactivex.Single

class GetAnimeDetailUseCase(val retrofitRepository: RetrofitRepository) {

    fun execute(id: Int): Single<Anime>? {
        return retrofitRepository.getAnimeDetail(id = id)
    }
}