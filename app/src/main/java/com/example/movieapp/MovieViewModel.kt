package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    val recyclerListData = MutableLiveData<MovieList>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val gameApi = MovieApi.create().getMovies()
        gameApi.enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.body() != null) {
                    recyclerListData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}