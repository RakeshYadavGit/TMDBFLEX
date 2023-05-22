package com.rawenginerring_.tmdbflexapp_.testing

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowRequests{

    @GET("/3/tv/{id}?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getTvShowInfo(@Path("id")id : String) : Call<MovieInfo>

    @GET("/3/tv/{id}/credits?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getCredits(@Path("id")id : String): Call<Credits>

    @GET("tv/{id}/videos")
    fun getVideos(@Path("id")id : String): Call<Videos>

    @GET("tv/{id}/images")
    fun getImages(@Path("id")id : String): Call<Images>

    @GET("/3/tv/{id}/reviews?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getReviews(@Path("id")id : String): Call<Review>

    @GET("/3/tv/{id}/similar?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getSimilar(@Path("id")id : String): Call<MovieList>

    @GET("tv/{id}/similar")
    fun getSimilar(@Path("id")id : String, @Query("page") page :String): Call<MovieList>



    @GET("tv/popular")
    fun getPopularTvShow() : Call<SmallItemList>


    @GET("tv/top_rated")
    fun getTopRatedTvShow() : Call<SmallItemList>


    @GET("tv/popular")
    fun getPopular(@Query("page") page :String) : Call<MovieList>

    @GET("tv/top_rated")
    fun getTopRated(@Query("page") page :String) : Call<MovieList>

}