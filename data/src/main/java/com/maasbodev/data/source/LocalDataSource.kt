package com.maasbodev.data.source

import com.maasbodev.domain.Beer

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveBeers(beers: List<Beer>)
    suspend fun getAllBeers(): List<Beer>
    suspend fun searchBeer(search: String): List<Beer>
    suspend fun getBeerById(id: Int): Beer
}