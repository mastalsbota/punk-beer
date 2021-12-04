package com.maasbodev.punkbeer.data.database

import com.maasbodev.data.source.LocalDataSource
import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.data.toDomainBeer
import com.maasbodev.punkbeer.data.toRoomBeer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: BeerDatabase) : LocalDataSource {

    private val beerDao = db.beerDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { beerDao.beerCount() <= 0 }

    override suspend fun saveBeers(beers: List<Beer>) {
        withContext(Dispatchers.IO) { beerDao.insertBeers(beers.map { it.toRoomBeer() }) }
    }

    override suspend fun getAllBeers(): List<Beer> = withContext(Dispatchers.IO) {
        beerDao.getAllBeers().map { it.toDomainBeer() }
    }

    override suspend fun getBeerById(id: Int): Beer = withContext(Dispatchers.IO) {
        beerDao.getBeerById(id).toDomainBeer()
    }

}