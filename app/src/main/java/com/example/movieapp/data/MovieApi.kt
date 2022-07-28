package com.example.movieapp.data

import retrofit2.http.GET

interface MovieApi {

    @GET("/svc/movies/v2/reviews/all.json?api-key=IBEX2GLB3OwlbQf63jK06qTnfDdgNDSA")
    suspend fun getMovies(): MovieList
}