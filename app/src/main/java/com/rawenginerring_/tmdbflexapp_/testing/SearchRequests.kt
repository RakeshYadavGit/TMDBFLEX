package com.rawenginerring_.tmdbflexapp_.testing

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRequests {

    @GET("/3/search/movie?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getMovie(@Query("page")page : String,@Query("query")query : String) : Call<Search>

    @GET("/3/search/tv?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getTv(@Query("page")page : String,@Query("query")query : String) : Call<Search>

    @GET("/3/search/person?api_key=3e791f84aae0f6840b7876eef9d6756b")
    fun getPerson(@Query("page")page : String,@Query("query")query : String) : Call<Search>
}