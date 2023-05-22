package com.rawenginerring_.tmdbflexapp_.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowResponse(
    @SerializedName("results")
    val tvShows : List<TVShowModel>

) : Parcelable {
    constructor() : this(mutableListOf())
}