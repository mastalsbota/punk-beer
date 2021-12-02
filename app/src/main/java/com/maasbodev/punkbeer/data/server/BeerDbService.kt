package com.maasbodev.punkbeer.data.server

import retrofit2.http.GET

interface BeerDbService {

    @GET("beers")
    suspend fun listAllBeersAsync() : BeersDbResult

}