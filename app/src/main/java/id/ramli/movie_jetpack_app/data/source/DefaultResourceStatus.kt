package id.ramli.movie_jetpack_app.data.source

data class DefaultResourceStatus<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): DefaultResourceStatus<T> = DefaultResourceStatus(Status.SUCCESS, data, null)

        fun <T> error(msg: String?, data: T?): DefaultResourceStatus<T> = DefaultResourceStatus(Status.ERROR, data, msg)

        fun <T> loading(data: T?): DefaultResourceStatus<T> = DefaultResourceStatus(Status.LOADING, data, null)
    }
}