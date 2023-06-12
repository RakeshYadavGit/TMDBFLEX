package com.rawenginerring_.tmdbflexapp_.DataFactory

import com.rawenginerring_.tmdbflexapp_.services.MovieApiInterface
import com.cronocode.moviecatalog.services.MovieApiService
import com.rawenginerring_.tmdbflexapp_.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieDataFactory{
    val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)

    fun getTopRatedChildren(callback: (List<MovieModel>) -> Unit) {
        val children = mutableListOf<MovieModel>()
        getTopRatedMovieData { movies ->
            movies.forEach { movie ->
                children.add(movie)
            }
            callback(children)
        }
    }

    fun getPopularChildren(callback: (List<MovieModel>) -> Unit) {
        val children = mutableListOf<MovieModel>()
        getTopRatedMovieData { movies ->
            movies.forEach { movie ->
                children.add(movie)
            }
            callback(children)
        }
    }


    fun getUpcomingMovieChildren(callback: (List<MovieModel>) -> Unit) {
        val children = mutableListOf<MovieModel>()
        getUpcomingMovieData { movies ->
            movies.forEach { movie ->
                children.add(movie)
            }
            callback(children)
        }
    }

    fun getLatestMovieChildren(callback: (List<MovieModel>) -> Unit) {
        val children = mutableListOf<MovieModel>()
        getLatestMovieData { movies ->
            movies.forEach { movie ->
                children.add(movie)
            }
            callback(children)
        }
    }

    fun getNowPlayingMovieChildren(callback: (List<MovieModel>) -> Unit) {
        val children = mutableListOf<MovieModel>()
        getNowPlayingMovieData { movies ->
            movies.forEach { movie ->
                children.add(movie)
                println("Movie details: $movie")
            }
            callback(children)
        }
    }

    fun getPopularTVShowChildren(callback: (List<TVShowModel>) -> Unit) {
        val children = mutableListOf<TVShowModel>()
        getPopularTVShowData { movies ->
            movies.forEach { movie ->
                children.add(movie)
            }
            callback(children)
        }
    }

    fun getLatestTVShowChildren(callback: (List<TVShowModel>) -> Unit) {
        val children = mutableListOf<TVShowModel>()
        getLatestTVShowData { movies ->
            movies.forEach { movie ->
                children.add(movie)
            }
            callback(children)
        }
    }

    fun getTopRatedTVShowChildren(callback: (List<TVShowModel>) -> Unit) {
        val children = mutableListOf<TVShowModel>()
        getTopRatedTVShowData { movies ->
            movies.forEach { movie ->
                children.add(movie)
                println("Movie details: $movie")
            }
            callback(children)
        }
    }

    fun getMovieDetailsChildren(movieId: Int, callback: (List<MovieDetailsModel>) -> Unit) {
        val children = mutableListOf<MovieDetailsModel>()
        getMovieDetails(movieId) { movies ->
            movies.forEach { movie ->
                children.add(movie)
                println("Movie details: $movie")
            }
            callback(children)
        }
    }

    private fun getPopularMovieData(callback: (List<MovieModel>) -> Unit){
        apiService.getPopularMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun getTopRatedMovieData(callback: (List<MovieModel>) -> Unit){
        apiService.getTopRatedMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun getUpcomingMovieData(callback: (List<MovieModel>) -> Unit){
        apiService.getUpcomingMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun getNowPlayingMovieData(callback: (List<MovieModel>) -> Unit){
        apiService.getNowPlayingMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun getLatestMovieData(callback: (List<MovieModel>) -> Unit){
        apiService.getLatestMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun getPopularTVShowData(callback: (List<TVShowModel>) -> Unit){
        apiService.getPopularTvShowList().enqueue(object : Callback<TVShowResponse> {
            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVShowResponse>, response: Response<TVShowResponse>) {
                return callback(response.body()!!.tvShows)
            }

        })
    }

    private fun getLatestTVShowData(callback: (List<TVShowModel>) -> Unit){
        apiService.getLatestTVList().enqueue(object : Callback<TVShowResponse> {
            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVShowResponse>, response: Response<TVShowResponse>) {
                return callback(response.body()!!.tvShows)
            }

        })
    }

    private fun getTopRatedTVShowData(callback: (List<TVShowModel>) -> Unit){
        apiService.getTopRatedTVList().enqueue(object : Callback<TVShowResponse> {
            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVShowResponse>, response: Response<TVShowResponse>) {
                return callback(response.body()!!.tvShows)
            }

        })
    }

    private fun getMovieDetails(movieId: Int, callback: (List<MovieDetailsModel>) -> Unit) {
        apiService.getDetails(movieId)
            .enqueue(object : Callback<MovieDetailsResponse> {
                override fun onResponse(call: Call<MovieDetailsResponse>, response: Response<MovieDetailsResponse>) {
                    if (response.isSuccessful) {
                        val movieDetails = response.body()?.results
                        println("Movie details: $movieDetails")
                        if (movieDetails != null) {
                            return callback(movieDetails)
                        }
                    } else {
                        println("Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {
                    println("Error: ${t.message}")
                }
            })
    }


}