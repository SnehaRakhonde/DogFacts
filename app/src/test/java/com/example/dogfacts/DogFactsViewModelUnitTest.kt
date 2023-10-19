package com.example.dogfacts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dogFacts.data.DogFactsRepository
import com.example.dogFacts.service.DogFactsServiceAPI
import com.example.dogFacts.viewmodels.DogFactsViewModel
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DogFactsViewModelUnitTest {

    private lateinit var dogFactsRepository: DogFactsRepository
    private lateinit var dogFactsServiceAPI: DogFactsServiceAPI
    private lateinit var viewModel: DogFactsViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        dogFactsServiceAPI = mockk()
        dogFactsRepository = DogFactsRepository(dogFactsServiceAPI)
        viewModel = DogFactsViewModel(dogFactsRepository)
    }

    @Test
    fun test_fetch_dog_facts() {
        viewModel.fetchDogFacts()
        Assert.assertEquals(viewModel.dogFacts.getOrAwaitValue().size,10)
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}