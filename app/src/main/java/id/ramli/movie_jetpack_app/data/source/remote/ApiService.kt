package id.ramli.movie_jetpack_app.data.source.remote

import id.ramli.movie_jetpack_app.BuildConfig
import id.ramli.movie_jetpack_app.data.source.DefaultResponse
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieResponse
import id.ramli.movie_jetpack_app.data.source.movie.MovieResponse
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowResponse
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/upcoming")
    fun getMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<DefaultResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<DetailMovieResponse>

    @GET("tv/popular")
    fun getTvShows(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<DefaultResponse<TvShowResponse>>

    @GET("tv/{tv_show_id}")
    fun getDetailTvShow(
        @Path("tv_show_id") tvShowId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<DetailTvShowResponse>

}