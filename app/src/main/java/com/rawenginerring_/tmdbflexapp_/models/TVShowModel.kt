package com.rawenginerring_.tmdbflexapp_.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowModel (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val title : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("vote_average")
    val vote_average : String?

) : Parcelable {
    constructor() : this(null,"","","")
}
