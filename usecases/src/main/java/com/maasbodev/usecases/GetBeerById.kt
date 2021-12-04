package com.maasbodev.usecases

import com.maasbodev.data.repository.BeersRepository
import com.maasbodev.domain.Beer

class GetBeerById(private val beersRepository: BeersRepository) {
    suspend fun invoke(id: Int): Beer = beersRepository.getBeerById(id)
}