package id.ramli.movie_jetpack_app.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieRepository
import javax.inject.Inject

/**
 * Created by ramliy10 on 04/05/21.
 */
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<DefaultResourceStatus<PagedList<MovieEntity>>> = movieRepository.getMovies()

    fun getFavoriteMovies(): LiveData<PagedList<DetailMovieEntity>> = movieRepository.getFavoriteMovies()

}