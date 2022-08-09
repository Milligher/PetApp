package com.milligher.petapp.domain.useCase

import com.milligher.petapp.domain.model.api.Anime
import com.milligher.petapp.domain.repository.RetrofitRepository
import io.reactivex.Single

class GetAllAnimeUseCase(val retrofitRepository: RetrofitRepository) {

    fun execute(): Single<List<Anime>>? {
        return retrofitRepository.getAllAnime()
    }
}