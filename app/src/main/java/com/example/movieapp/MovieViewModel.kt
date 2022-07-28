package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieApi: MovieApi
) : ViewModel() {
    val recyclerListData = MutableLiveData<MovieList>()
    val errorMessage = MutableLiveData<String>()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            try {
                val movieApi = movieApi.getMovies()
                recyclerListData.postValue(movieApi)
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }
}