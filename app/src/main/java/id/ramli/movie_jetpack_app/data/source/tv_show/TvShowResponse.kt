package id.ramli.movie_jetpack_app.data.source.tv_show

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse (
    @SerializedName("id")
    val tvShowId: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("first_air_date")
    val release: String,
    @SerializedName("vote_average")
    val rating: String
) : Parcelable