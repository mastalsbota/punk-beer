package com.maasbodev.punkbeer.data.server.entities

data class Ingredients(
    val hops: List<Hops>,
    val malt: List<Malt>,
    val yeast: String
)