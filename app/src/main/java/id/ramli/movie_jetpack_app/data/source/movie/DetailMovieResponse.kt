package id.ramli.movie_jetpack_app.data.source.movie

import com.google.gson.annotations.SerializedName

data class DetailMovieResponse (
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
    val rating: String,
    @SerializedName("runtime")
    val duration: String
)