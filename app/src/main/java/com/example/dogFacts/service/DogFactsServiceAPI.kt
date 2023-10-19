package com.example.dogFacts.service

import com.example.dogFacts.model.DogsFactsResponse
import retrofit2.http.GET

interface DogFactsServiceAPI {
    @GET("facts?number=10")
    suspend fun getDogFacts(): DogsFactsResponse
}