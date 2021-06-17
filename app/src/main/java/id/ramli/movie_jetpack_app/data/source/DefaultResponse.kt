package id.ramli.movie_jetpack_app.data.source

import com.google.gson.annotations.SerializedName

/**
 * Created by ramliy10 on 02/06/21.
 */
data class DefaultResponse<T> (
    @SerializedName("results")
    val data: List<T>
)