package com.example.movieapp.di

import com.example.movieapp.GetMovieUseCase
import com.example.movieapp.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class MovieModule {

    @Provides
    fun provideGetMovieUseCase(movieApi: MovieApi): GetMovieUseCase {
        return GetMovieUseCase(movieApi)
    }
}