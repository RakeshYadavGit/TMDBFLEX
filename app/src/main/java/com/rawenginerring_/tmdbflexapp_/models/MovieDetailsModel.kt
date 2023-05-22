package com.rawenginerring_.tmdbflexapp_.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetailsModel(
    @SerializedName("adult")
    val adult: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("belongs_to_collection")
    val belongsToCollection: String? = null,

    @SerializedName("budget")
    val budget: String? = null,

    @SerializedName("genres")
    val genres: String? = null,

    @SerializedName("homepage")
    val homepage: String? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("imdb_id")
    val imdbId: String? = null,

    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity: String? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("production_companies")
    val productionCompanies: String? = null,

    @SerializedName("production_countries")
    val productionCountries: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("revenue")
    val revenue: String? = null,

    @SerializedName("runtime")
    val runtime: String? = null,

    @SerializedName("spoken_languages")
    val spokenLanguages: String? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("tagline")
    val tagline: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("video")
    val video: String? = null,

    @SerializedName("vote_average")
    val voteAverage: String? = null,

    @SerializedName("vote_count")
    val voteCount: String? = null
) : Parcelable{
    constructor():this("","","","","",
        "","","","","","","",
        "","","","","","",
        "","","","","","","")
}

@Parcelize
data class Genre(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null
) : Parcelable

@Parcelize
data class ProductionCompany(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("logo_path")
    val logoPath: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("origin_country")
    val originCountry: String? = null
) : Parcelable

@Parcelize
data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String? = null,

    @SerializedName("name")
    val name: String? = null
) : Parcelable

@Parcelize
data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String? = null,

    @SerializedName("iso_639_1")
    val iso6391: String? = null,

    @SerializedName("name")
    val name: String? = null
) : Parcelable

