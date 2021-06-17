package id.ramli.movie_jetpack_app.data.source

class ApiResponse<T>(val status: StatusResponse, val body: T?, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)

        fun <T> error(msg: String): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, null, msg)
    }
}