package id.ramli.movie_jetpack_app.data.source.tv_show

import com.google.gson.annotations.SerializedName

/**
 * Created by ramliy10 on 01/06/21.
 */
data class DetailTvShowResponse(
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
    val status: String,
    @SerializedName("vote_average")
    val rating: String
)