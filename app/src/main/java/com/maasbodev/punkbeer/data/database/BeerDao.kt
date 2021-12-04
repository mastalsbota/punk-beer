package com.maasbodev.punkbeer.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BeerDao {

    @Query("SELECT * FROM beer")
    fun getAllBeers(): List<Beer>

    @Query("SELECT * FROM Beer WHERE id = :id")
    fun getBeerById(id: Int): Beer

    @Query("SELECT COUNT(id) FROM Beer")
    fun beerCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBeers(beers: List<Beer>)

}