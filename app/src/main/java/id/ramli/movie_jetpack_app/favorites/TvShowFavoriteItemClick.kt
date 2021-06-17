package id.ramli.movie_jetpack_app.favorites

import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity

interface TvShowFavoriteItemClick {
    fun onTvShowFavoriteItemCLicked(detailTvShowEntity: DetailTvShowEntity)
}