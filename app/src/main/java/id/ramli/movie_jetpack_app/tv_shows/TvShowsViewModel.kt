package id.ramli.movie_jetpack_app.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository
import javax.inject.Inject

/**
 * Created by ramliy10 on 07/05/21.
 */
class TvShowsViewModel @Inject constructor(private val tvShowsRepository: TvShowRepository) : ViewModel() {

    fun getTvShows(): LiveData<DefaultResourceStatus<PagedList<TvShowEntity>>> = tvShowsRepository.getTvShows()

    fun getFavoriteTvShows(): LiveData<PagedList<DetailTvShowEntity>> = tvShowsRepository.getFavoriteTvShows()

}