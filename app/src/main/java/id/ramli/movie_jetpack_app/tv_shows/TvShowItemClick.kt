package id.ramli.movie_jetpack_app.tv_shows

import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity

/**
 * Created by ramliy10 on 05/06/21.
 */
interface TvShowItemClick {
    fun onTvShowItemCLicked(tvShowEntity: TvShowEntity)
}