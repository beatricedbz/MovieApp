package com.example.movieapp

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/svc/movies/v2/reviews/all.json?api-key=IBEX2GLB3OwlbQf63jK06qTnfDdgNDSA")
    suspend fun getMovies(
        @Query("offset") offset: Int
    ): MovieList
}