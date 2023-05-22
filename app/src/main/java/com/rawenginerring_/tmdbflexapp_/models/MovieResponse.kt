package com.rawenginerring_.tmdbflexapp_.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies : List<MovieModel>

) : Parcelable {
    constructor() : this(mutableListOf())
}