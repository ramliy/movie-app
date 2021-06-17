package id.ramli.movie_jetpack_app.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ramli.movie_jetpack_app.data.source.ApiResponse
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieResponse
import id.ramli.movie_jetpack_app.data.source.movie.MovieResponse
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowResponse
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowResponse
import id.ramli.movie_jetpack_app.di.ApiModule
import id.ramli.movie_jetpack_app.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val responseMovies = apiService.getMovies().await()
                resultMovies.postValue(ApiResponse.success(responseMovies.data))
            } catch (e: IOException) {
                resultMovies.postValue(
                    ApiResponse.error(
                        e.message.toString()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovies
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        CoroutineScope(IO).launch {
            try {
                val responseMovie = apiService.getDetailMovie(movieId).await()
                resultMovie.postValue(ApiResponse.success(responseMovie))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovie.postValue(ApiResponse.error(e.message.toString()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val responseTvShows = apiService.getTvShows().await()
                resultTvShows.postValue(ApiResponse.success(responseTvShows.data))
            } catch (e: IOException) {
                resultTvShows.postValue(
                    ApiResponse.error(
                        e.message.toString()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShows
    }

    fun getDetailTvShow(tvShow: Int): LiveData<ApiResponse<DetailTvShowResponse>>{
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<DetailTvShowResponse>>()
        CoroutineScope(IO).launch {
            try {
                val responseTvShow = apiService.getDetailTvShow(tvShow).await()
                resultTvShow.postValue(ApiResponse.success(responseTvShow))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShow.postValue(ApiResponse.error(e.message.toString()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShow
    }
}