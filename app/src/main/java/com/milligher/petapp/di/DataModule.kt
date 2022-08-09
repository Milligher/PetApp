package com.milligher.petapp.di

import com.milligher.petapp.data.repository.RetrofitRepositoryImpl
import com.milligher.petapp.domain.repository.RetrofitRepository
import com.milligher.petapp.domain.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideAppRepository(serverCommunicator: ServerCommunicator): RetrofitRepository {
        return RetrofitRepositoryImpl(serverCommunicator = serverCommunicator)
    }
}