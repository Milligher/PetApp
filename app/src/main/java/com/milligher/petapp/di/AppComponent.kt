package com.milligher.petapp.di

import com.milligher.petapp.presentation.activities.detail.DetailActivity
import com.milligher.petapp.presentation.activities.main.MainActivity
import com.milligher.petapp.presentation.fragments.main.MainFragment
import com.milligher.petapp.presentation.fragments.saved.SavedFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModel::class], dependencies = [ApiComponent::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(savedFragment: SavedFragment)
}