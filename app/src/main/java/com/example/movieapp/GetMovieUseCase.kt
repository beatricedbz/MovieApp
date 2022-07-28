package com.example.movieapp

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val movieApi: MovieApi
) {
    val movies = MutableStateFlow(listOf<Movie>())

    private var currentOffset = 0
    private var hasMoreMovies = true

    suspend fun getMovies() {
        if (hasMoreMovies) {
            try {

                val movieResponse = movieApi.getMovies(currentOffset)
                currentOffset += DEFAULT_OFFSET
                hasMoreMovies = movieResponse.hasMore
                movies.value = listOf(movies.value, movieResponse.results).flatten()
            } catch (e: Exception) {

            }
        }
    }

    companion object {
        private const val DEFAULT_OFFSET = 20
    }
}