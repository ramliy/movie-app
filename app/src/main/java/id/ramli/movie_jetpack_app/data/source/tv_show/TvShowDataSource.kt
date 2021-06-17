package id.ramli.movie_jetpack_app.data.source.tv_show

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus

/**
 * Created by ramliy10 on 01/06/21.
 */
interface TvShowDataSource {
    fun getTvShows(): LiveData<DefaultResourceStatus<PagedList<TvShowEntity>>>
    fun getDetailTvShow(tvShowId: Int): LiveData<DefaultResourceStatus<DetailTvShowEntity>>
    fun getFavoriteTvShows(): LiveData<PagedList<DetailTvShowEntity>>
    fun setFavoriteTvShow(detailTvShowEntity: DetailTvShowEntity)
}