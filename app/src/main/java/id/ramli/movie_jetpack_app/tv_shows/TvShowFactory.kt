package id.ramli.movie_jetpack_app.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository
import id.ramli.movie_jetpack_app.detail.DetailTvShowViewModel
import javax.inject.Inject

/**
 * Created by ramliy10 on 01/06/21.
 */
class TvShowFactory @Inject constructor(private val tvShowRepository: TvShowRepository): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(model: Class<T>): T {
        return when {
            model.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(tvShowRepository) as T
            }
            model.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(tvShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel: " + model.name)
        }

    }

}