package com.maasbodev.punkbeer.data.server

import com.maasbodev.data.source.RemoteDataSource
import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.data.toDomainBeer


class BeerDbDataSource : RemoteDataSource {

    override suspend fun getAllBeers(): List<Beer> =
        BeerDb.service
            .listAllBeersAsync()
            .results
            .map { it.toDomainBeer() }

    override suspend fun searchBeer(search: String): List<Beer> =
        BeerDb.service
            .searchBeer(search)
            .results
            .map { it.toDomainBeer() }

}