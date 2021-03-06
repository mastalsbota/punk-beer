package com.maasbodev.data.source

import com.maasbodev.domain.Beer

interface RemoteDataSource {
    suspend fun getAllBeers(): List<Beer>
    suspend fun searchBeer(search: String): List<Beer>
}