package com.rawenginerring_.tmdbflexapp_.testing

import com.rawenginerring_.tmdbflexapp_.testing.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieItemRequests {

    @GET("movie/now_playing")
    fun getNowPlaying() : Call<SmallItemList>

    @GET("movie/upcoming")
    fun getUpcoming() : Call<SmallItemList>

    @GET("movie/popular")
    fun getPopular() : Call<SmallItemList>

    @GET("movie/top_rated")
    fun getTopRated() : Call<SmallItemList>




    @GET("movie/now_playing")
    fun getNowPlaying(@Query("page") page :String) : Call<MovieList>

    @GET("movie/upcoming")
    fun getUpcoming(@Query("page") page :String) : Call<MovieList>

    @GET("movie/popular")
    fun getPopular(@Query("page") page :String) : Call<MovieList>

    @GET("movie/top_rated")
    fun getTopRated(@Query("page") page :String) : Call<MovieList>


    @GET("/3/movie/{id}?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getMovieInfo(@Path("id")id : String) : Call<MovieInfo>

    @GET("/3/movie/{id}/credits?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getCredits(@Path("id")id : String): Call<Credits>

    @GET("movie/{id}/videos")
    fun getVideos(@Path("id")id : String): Call<Videos>

    @GET("movie/{id}/images")
    fun getImages(@Path("id")id : String): Call<Images>

    @GET("/3/movie/{id}/reviews?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getReviews(@Path("id")id : String): Call<Review>

    @GET("/3/movie/{id}/similar?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getSimilar(@Path("id")id : String): Call<MovieList>

    @GET("/3/movie/{id}/similar?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getSimilar(@Path("id")id : String, @Query("page") page :String): Call<MovieList>

}