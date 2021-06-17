package id.ramli.movie_jetpack_app.data.source.tv_show

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.ApiResponse
import id.ramli.movie_jetpack_app.data.source.NetworkDispatcherResource
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.local.LocalDataSource
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by ramliy10 on 01/06/21.
 */
class TvShowRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : TvShowDataSource {
    override fun getTvShows(): LiveData<DefaultResourceStatus<PagedList<TvShowEntity>>> {
        return object : NetworkDispatcherResource<PagedList<TvShowEntity>, List<TvShowResponse>>() {
            override fun loadDataFromDB(): LiveData<PagedList<TvShowEntity>> {
                val data = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getLocalTvShows(), data).build()
            }

            override fun shouldFetchData(data: PagedList<TvShowEntity>?): Boolean =
                data.isNullOrEmpty()


            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShows()

            override fun saveDataCallResult(data: List<TvShowResponse>) {
                val tvShows = ArrayList<TvShowEntity>()
                for (tvShow in data){
                    val itemMovie = TvShowEntity(
                        null,
                        tvShow.tvShowId,
                        tvShow.title,
                        tvShow.description,
                        tvShow.poster,
                        tvShow.release,
                        tvShow.rating,
                        false
                    )
                    tvShows.add(itemMovie)
                }
                localDataSource.insertLocalTvShows(tvShows)
            }

        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<DefaultResourceStatus<DetailTvShowEntity>> {
        return object : NetworkDispatcherResource<DetailTvShowEntity, DetailTvShowResponse>(){
            override fun loadDataFromDB(): LiveData<DetailTvShowEntity> = localDataSource.getLocalDetailTvShow(tvShowId)

            override fun shouldFetchData(data: DetailTvShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveDataCallResult(data: DetailTvShowResponse) {
                val tvShow = DetailTvShowEntity(
                    null,
                    data.tvShowId,
                    data.title,
                    data.description,
                    data.poster,
                    data.release,
                    data.status,
                    data.rating,
                    false
                )
                localDataSource.insertLocalDetailTvShow(tvShow)
            }

        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<DetailTvShowEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavoriteTvShow(detailTvShowEntity: DetailTvShowEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setFavoriteTvShow(detailTvShowEntity)
        }
    }

}