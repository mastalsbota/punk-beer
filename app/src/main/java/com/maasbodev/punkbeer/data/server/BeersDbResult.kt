package com.maasbodev.punkbeer.data.server

import com.maasbodev.punkbeer.data.server.entities.Beer

data class BeersDbResult(
    val results: List<Beer>
)