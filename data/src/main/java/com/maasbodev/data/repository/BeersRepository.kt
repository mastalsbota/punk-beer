package com.maasbodev.data.repository

import com.maasbodev.data.source.LocalDataSource
import com.maasbodev.data.source.RemoteDataSource
import com.maasbodev.domain.Beer

class BeersRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getAllBeers(): List<Beer> {

        if (localDataSource.isEmpty()) {
            val beers = remoteDataSource.getAllBeers()
            localDataSource.saveBeers(beers)
        }

        return localDataSource.getAllBeers()
    }

    suspend fun searchBeer(search: String): List<Beer> {

        if (localDataSource.isEmpty()) {
            val beers = remoteDataSource.searchBeer(search)
            localDataSource.saveBeers(beers)
        }

        return localDataSource.searchBeer(search)
    }

    suspend fun getBeerById(id: Int): Beer = localDataSource.getBeerById(id)

}