package com.example.movieapp

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("has_more")
    val hasMore: Boolean,
    val results: List<Movie>
)

data class MovieImage(
    @SerializedName("src")
    val imageUrl: String
)

data class Movie(
    @SerializedName("display_title")
    val displayTitle: String,
    @SerializedName("summary_short")
    val summaryShort: String,
    val multimedia: MovieImage,
)