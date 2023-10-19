package com.example.dogFacts.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dogFacts.viewmodels.DogFactsViewModel

@Composable
fun DogFactsScreen(viewModel: DogFactsViewModel) {
    val dogFacts by viewModel.dogFacts.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchDogFacts()
    }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Dog Facts",
                style = MaterialTheme.typography.h6
            )
        }
        dogFacts.forEach {
            item -> DogFactItem(item)
        }
    }
}

@Composable
fun DogFactItem(dogFact: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = dogFact,
                style = MaterialTheme.typography.h6
            )
        }
    }
}