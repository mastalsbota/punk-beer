package com.maasbodev.punkbeer.data.server.entities

data class Method(
    val mash_temp: List<MashTemp>,
    val fermentation: Fermentation,
    val twist: Any
)