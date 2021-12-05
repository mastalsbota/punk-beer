package com.maasbodev.punkbeer.data.server

import retrofit2.http.GET
import retrofit2.http.Query

interface BeerDbService {

    @GET("beers")
    suspend fun listAllBeersAsync(): BeersDbResult

    @GET("beers")
    suspend fun searchBeer(
        @Query("beer_name") beerName: String
    ): BeersDbResult

}