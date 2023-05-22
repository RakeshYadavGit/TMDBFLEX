package com.rawenginerring_.tmdbflexapp_.testing



import android.os.Parcel
import android.os.Parcelable
import com.rawenginerring_.tmdbflexapp_.api.NetworkConstants
import com.google.gson.annotations.SerializedName

data class Credits(
    @SerializedName("cast")
    var cast: List<Cast> = listOf(),
    @SerializedName("crew")
    var crew: List<Crew> = listOf(),
    @SerializedName("id")
    var id: Int = 0
) {
    data class Cast(
        @SerializedName("name")
        var name: String = "",
        @SerializedName("character")
        var character: String = "",
        @SerializedName("profile_path")
        var profilePath: String = "",
        @SerializedName("cast_id")
        var castId: Int = 0,
        @SerializedName("credit_id")
        var creditId: String = "",
        @SerializedName("gender")
        var gender: Int = 0,
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("order")
        var order: Int = 0

    ){
        fun getImage():String{
            return NetworkConstants.baseImageUrl+profilePath
        }
    }

    data class Crew(
        @SerializedName("credit_id")
        var creditId: String = "",
        @SerializedName("department")
        var department: String = "",
        @SerializedName("gender")
        var gender: Int = 0,
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("job")
        var job: String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("profile_path")
        var profilePath: String = ""
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString()
        ) {
        }

        fun getImage():String{
            return NetworkConstants.baseImageUrl+profilePath
        }

        override fun describeContents(): Int {
            TODO("Not yet implemented")
        }

        override fun writeToParcel(p0: Parcel, p1: Int) {
            TODO("Not yet implemented")
        }

        companion object CREATOR : Parcelable.Creator<Crew> {
            override fun createFromParcel(parcel: Parcel): Crew {
                return Crew(parcel)
            }

            override fun newArray(size: Int): Array<Crew?> {
                return arrayOfNulls(size)
            }
        }
    }
}