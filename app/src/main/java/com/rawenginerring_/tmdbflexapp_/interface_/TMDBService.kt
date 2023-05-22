package com.rawenginerring_.tmdbflexapp_.interface_

import com.rawenginerring_.tmdbflexapp_.Data.MovieResult
import com.rawenginerring_.tmdbflexapp_.api.NetworkConstants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1
    ): MovieResult
}