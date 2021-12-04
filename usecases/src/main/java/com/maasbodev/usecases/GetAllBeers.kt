package com.maasbodev.usecases

import com.maasbodev.data.repository.BeersRepository
import com.maasbodev.domain.Beer

class GetAllBeers(private val beersRepository: BeersRepository) {
    suspend fun invoke(): List<Beer> = beersRepository.getAllBeers()
}