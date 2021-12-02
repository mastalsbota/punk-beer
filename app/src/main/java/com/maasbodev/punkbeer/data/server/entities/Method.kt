package com.maasbodev.punkbeer.data.server.entities

data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<MashTemp>,
    val twist: Any
)