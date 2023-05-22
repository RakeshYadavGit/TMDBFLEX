package com.rawenginerring_.tmdbflexapp_.Data

import com.cronocode.moviecatalog.services.MovieApiService
import com.rawenginerring_.tmdbflexapp_.testing.*

class MovieDetails_ {
    companion object{
        lateinit var movieInformation: MovieInfo
        lateinit var movieCreditInformation: Credits
        lateinit var movieRevieInformation: Review
        lateinit var similarMovieInformation: MovieList
        lateinit var searchMovie: Search
        lateinit var searchTv: Search
        lateinit var searchPeople: Search

        val movieApiService = MovieApiService.getInstance()

        val movieItemRequests = movieApiService.create(MovieItemRequests::class.java)
        val movieRepo = MovieItemRepository(movieItemRequests)

        val tvShowRequests = movieApiService.create(TvShowRequests::class.java)
        val tvRepo = TvShowRepository(tvShowRequests)

        val searchRequests = movieApiService.create( SearchRequests::class.java)
        val searchRepo = SearchRepository(searchRequests)


    }
}