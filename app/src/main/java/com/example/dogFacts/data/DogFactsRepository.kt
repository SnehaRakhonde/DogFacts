package com.example.dogFacts.data

import com.example.dogFacts.model.DogsFactsResponse
import com.example.dogFacts.service.DogFactsServiceAPI
import javax.inject.Inject

class DogFactsRepository @Inject constructor(private val dogFactsService: DogFactsServiceAPI) {

    suspend fun getDogFacts(): DogsFactsResponse {
        return dogFactsService.getDogFacts()
    }
}