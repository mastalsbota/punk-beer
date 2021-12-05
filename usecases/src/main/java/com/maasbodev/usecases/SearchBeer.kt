package com.maasbodev.usecases

import com.maasbodev.data.repository.BeersRepository
import com.maasbodev.domain.Beer

class SearchBeer(private val beersRepository: BeersRepository) {
    suspend fun invoke(search: String): List<Beer> = beersRepository.searchBeer(search)
}