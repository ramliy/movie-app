package id.ramli.movie_jetpack_app.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository

/**
 * Created by ramliy10 on 22/05/21.
 */
class DetailTvShowViewModel(private val tvShowRepository: TvShowRepository) : ViewModel(){
    fun getTvShowDetail(tvShowId: Int) : LiveData<DefaultResourceStatus<DetailTvShowEntity>> = tvShowRepository.getDetailTvShow(tvShowId)
    fun setTvShowFavorite(detailTvShowEntity: DetailTvShowEntity){
        tvShowRepository.setFavoriteTvShow(detailTvShowEntity)
    }
}