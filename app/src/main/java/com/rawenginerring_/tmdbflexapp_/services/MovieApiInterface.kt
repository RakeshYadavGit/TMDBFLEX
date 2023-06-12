package com.rawenginerring_.tmdbflexapp_.services

import com.rawenginerring_.tmdbflexapp_.models.MovieDetailsResponse
import com.rawenginerring_.tmdbflexapp_.models.MovieResponse
import com.rawenginerring_.tmdbflexapp_.models.TVShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getPopularMovieList(): Call<MovieResponse>

    @GET("/3/movie/top_rated?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getTopRatedMovieList(): Call<MovieResponse>

    @GET("/3/movie/upcoming?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getUpcomingMovieList(): Call<MovieResponse>

    @GET("/3/movie/now_playing?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getNowPlayingMovieList(): Call<MovieResponse>

    @GET("/3/movie/upcoming?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getLatestMovieList(): Call<MovieResponse>

    @GET("/3/tv/popular?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getPopularTvShowList(): Call<TVShowResponse>

    @GET("/3/tv/on_the_air?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getLatestTVList(): Call<TVShowResponse>

    @GET("/3/tv/top_rated?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getTopRatedTVList(): Call<TVShowResponse>


    @GET("/3/movie/{movie_id}?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getDetails(@Path("movie_id") id: Int): Call<MovieDetailsResponse>

}