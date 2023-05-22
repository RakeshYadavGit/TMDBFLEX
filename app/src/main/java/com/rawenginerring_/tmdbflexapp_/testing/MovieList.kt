package com.rawenginerring_.tmdbflexapp_.testing

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("results")
    var results: List<Result> = listOf(),
    @SerializedName("total_pages")
    var totalPages: Int = 0,
    @SerializedName("total_results")
    var totalResults: Int = 0
) {
    data class Result(
        @SerializedName("title")
        var title: String = "",
        @SerializedName("poster_path")
        var posterPath: String? = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("adult")
        var adult: Boolean = false,
        @SerializedName("backdrop_path")
        var backdropPath: String? = "",
        @SerializedName("genre_ids")
        var genreIds: List<Int> = listOf(),
        @SerializedName("original_language")
        var originalLanguage: String = "",
        @SerializedName("original_title")
        var originalTitle: String = "",
        @SerializedName("overview")
        var overview: String = "",
        @SerializedName("popularity")
        var popularity: Double = 0.0,
        @SerializedName("release_date")
        var releaseDate: String = "",
        @SerializedName("tagline")
        var tagline: String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("video")
        var video: Boolean = false,
        @SerializedName("vote_average")
        var voteAverage: Double = 0.0,
        @SerializedName("vote_count")
        var voteCount: Int = 0
    )
}
