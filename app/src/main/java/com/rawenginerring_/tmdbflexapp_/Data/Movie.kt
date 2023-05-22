package com.rawenginerring_.tmdbflexapp_.Data

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,
    @SerializedName("release_date") val releaseDate: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String
)

data class MovieResult(
    val results: List<Movie>
)


