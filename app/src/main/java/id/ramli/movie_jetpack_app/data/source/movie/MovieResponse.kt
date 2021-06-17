package id.ramli.movie_jetpack_app.data.source.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse (
    @SerializedName("id")
    val movieId: Int,
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("release_date")
    val release: String,
    @SerializedName("vote_average")
    val rating: String
) : Parcelable