package com.milligher.petapp.di

import com.milligher.petapp.domain.repository.RetrofitRepository
import com.milligher.petapp.domain.useCase.GetAllAnimeUseCase
import com.milligher.petapp.domain.useCase.GetAnimeDetailUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModel {

    @Provides
    fun provideGetAllAnimeUseCase(retrofitRepository: RetrofitRepository): GetAllAnimeUseCase {
        return GetAllAnimeUseCase(retrofitRepository = retrofitRepository)
    }

    @Provides
    fun provideGetAnimeDetailUseCase(retrofitRepository: RetrofitRepository): GetAnimeDetailUseCase {
        return GetAnimeDetailUseCase(retrofitRepository = retrofitRepository)
    }
}