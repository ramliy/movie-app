package id.ramli.movie_jetpack_app.data.source.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus

/**
 * Created by ramliy10 on 28/05/21.
 */
interface MovieDataSource {
    fun getMovies(): LiveData<DefaultResourceStatus<PagedList<MovieEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<DefaultResourceStatus<DetailMovieEntity>>
    fun getFavoriteMovies(): LiveData<PagedList<DetailMovieEntity>>
    fun setFavoriteMovie(detailMovieEntity: DetailMovieEntity)
}