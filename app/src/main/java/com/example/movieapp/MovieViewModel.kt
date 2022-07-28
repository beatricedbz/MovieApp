package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    val recyclerListData = MutableLiveData<MovieList>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        viewModelScope.launch {
            try {
                val gameApi = MovieApi.create().getMovies()
                recyclerListData.postValue(gameApi)
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }
}