package com.example.movieapp.data

data class MovieList(val results: List<Movie>)

data class MovieImage(val src: String)

data class Movie(
    val display_title: String,
    val summary_short: String,
    val multimedia: MovieImage,
)