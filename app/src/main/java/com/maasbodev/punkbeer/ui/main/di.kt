package com.maasbodev.punkbeer.ui.main

import com.maasbodev.data.repository.BeersRepository
import com.maasbodev.usecases.GetAllBeers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    @ViewModelScoped
    fun getAllBeersProvider(beersRepository: BeersRepository) = GetAllBeers(beersRepository)

}