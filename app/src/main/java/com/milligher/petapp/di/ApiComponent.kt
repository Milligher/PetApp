package com.milligher.petapp.di

import com.milligher.petapp.domain.repository.server.ServerCommunicator
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}