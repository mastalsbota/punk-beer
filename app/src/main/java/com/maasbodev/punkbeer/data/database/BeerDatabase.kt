package com.maasbodev.punkbeer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Beer::class], version = 1)
abstract class BeerDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao

}