package com.maasbodev.punkbeer.di

import com.maasbodev.data.repository.BeersRepository
import com.maasbodev.data.source.LocalDataSource
import com.maasbodev.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun beersRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = BeersRepository(localDataSource, remoteDataSource)

}