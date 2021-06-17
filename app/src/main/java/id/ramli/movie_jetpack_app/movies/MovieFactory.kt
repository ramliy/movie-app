package id.ramli.movie_jetpack_app.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ramli.movie_jetpack_app.data.source.movie.MovieRepository
import id.ramli.movie_jetpack_app.detail.DetailMovieViewModel
import javax.inject.Inject

/**
 * Created by ramliy10 on 01/06/21.
 */
class MovieFactory @Inject constructor(private val movieRepository: MovieRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(model: Class<T>): T {
        return when {
            model.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieRepository) as T
            }
            model.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel: " + model.name)
        }

    }
}