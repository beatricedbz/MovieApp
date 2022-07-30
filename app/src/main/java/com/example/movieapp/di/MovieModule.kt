package com.example.movieapp.di

import com.example.movieapp.domain.GetMovieUseCase
import com.example.movieapp.data.MovieApi
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