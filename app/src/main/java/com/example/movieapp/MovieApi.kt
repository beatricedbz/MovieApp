package com.example.movieapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {

    @GET("/svc/movies/v2/reviews/all.json?api-key=IBEX2GLB3OwlbQf63jK06qTnfDdgNDSA")
    suspend fun getMovies(): MovieList

    companion object {

        var BASE_URL = "https://api.nytimes.com"

        fun create(): MovieApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(MovieApi::class.java)
        }
    }

}