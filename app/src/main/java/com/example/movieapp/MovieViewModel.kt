package com.example.movieapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    val recyclerListData = getMovieUseCase.movies.asLiveData()

    init {
        getAllMovies()
    }

    fun getAllMovies() {
        viewModelScope.launch {
            getMovieUseCase.getMovies()
        }
    }
}