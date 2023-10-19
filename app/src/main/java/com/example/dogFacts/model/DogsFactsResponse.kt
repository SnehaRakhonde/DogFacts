package com.example.dogFacts.model

data class DogsFactsResponse(
    val facts: List<String>,
    val success: Boolean
)