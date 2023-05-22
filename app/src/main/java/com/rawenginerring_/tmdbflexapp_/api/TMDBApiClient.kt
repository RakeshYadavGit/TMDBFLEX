package com.rawenginerring_.tmdbflexapp_.api

import com.rawenginerring_.tmdbflexapp_.Data.Movie
import com.rawenginerring_.tmdbflexapp_.api.NetworkConstants.baseUrl
import com.rawenginerring_.tmdbflexapp_.interface_.TMDBService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TMDBApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val tmdbService = retrofit.create(TMDBService::class.java)

    private suspend fun getUpcomingMovies(): List<Movie> {
        val result = tmdbService.getUpcomingMovies()
        return result.results
    }
}