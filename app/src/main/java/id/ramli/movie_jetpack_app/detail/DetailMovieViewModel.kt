package id.ramli.movie_jetpack_app.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieRepository
import javax.inject.Inject

/**
 * Created by ramliy10 on 17/05/21.
 */
class DetailMovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel(){

    fun getMovieDetail(movieId: Int) : LiveData<DefaultResourceStatus<DetailMovieEntity>> = movieRepository.getDetailMovie(movieId)

    fun setMovieFavorite(detailMovieEntity: DetailMovieEntity){
        movieRepository.setFavoriteMovie(detailMovieEntity)
    }
}