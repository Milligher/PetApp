package com.milligher.petapp

import android.app.Application
import com.milligher.petapp.di.*

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        appComponent = DaggerAppComponent.builder()
            .apiComponent(apiComponent)
            .appModule(AppModule(context = this))
            .build()
    }
}