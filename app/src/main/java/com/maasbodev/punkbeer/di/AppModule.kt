package com.maasbodev.punkbeer.di

import android.app.Application
import androidx.room.Room
import com.maasbodev.data.source.LocalDataSource
import com.maasbodev.data.source.RemoteDataSource
import com.maasbodev.punkbeer.data.database.BeerDatabase
import com.maasbodev.punkbeer.data.database.RoomDataSource
import com.maasbodev.punkbeer.data.server.BeerDbDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        BeerDatabase::class.java,
        "beer-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: BeerDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = BeerDbDataSource()

}