package com.rawenginerring_.tmdbflexapp_.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailsResponse(
    @SerializedName("results")
    val results : List<MovieDetailsModel>

) : Parcelable {
    constructor() : this(mutableListOf())
}
