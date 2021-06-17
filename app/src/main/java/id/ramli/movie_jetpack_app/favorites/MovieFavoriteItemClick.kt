package id.ramli.movie_jetpack_app.favorites

import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity

interface MovieFavoriteItemClick {
    fun onMovieFavoriteItemClicked(detailMovieEntity: DetailMovieEntity)
}