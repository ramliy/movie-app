package id.ramli.movie_jetpack_app.movies

import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity

/**
 * Created by ramliy10 on 05/06/21.
 */
interface MovieItemClick {
    fun onMovieItemClicked(movieEntity: MovieEntity)
}