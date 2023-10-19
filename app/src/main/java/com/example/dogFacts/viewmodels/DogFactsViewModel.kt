package com.example.dogFacts.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogFacts.data.DogFactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogFactsViewModel @Inject constructor(private val repository: DogFactsRepository): ViewModel() {

    private val _dogFacts = MutableLiveData<List<String>>()
    val dogFacts: LiveData<List<String>> = _dogFacts

    fun fetchDogFacts() {
        viewModelScope.launch {
            try {
                val facts = repository.getDogFacts()
                _dogFacts.value = facts.facts
                Log.e("_dogFacts", _dogFacts.value.toString())
            } catch (e: Exception) {
                // Handle error
                Log.e("DogFactResponse", e.message.toString())
            }
        }
    }
}