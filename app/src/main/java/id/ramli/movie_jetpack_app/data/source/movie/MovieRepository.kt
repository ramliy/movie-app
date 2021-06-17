package id.ramli.movie_jetpack_app.data.source.movie

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.ApiResponse
import id.ramli.movie_jetpack_app.data.source.NetworkDispatcherResource
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.local.LocalDataSource
import id.ramli.movie_jetpack_app.data.source.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by ramliy10 on 28/05/21.
 */
class MovieRepository @Inject constructor
    (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieDataSource {
    override fun getMovies(): LiveData<DefaultResourceStatus<PagedList<MovieEntity>>> {
        return object : NetworkDispatcherResource<PagedList<MovieEntity>, List<MovieResponse>>() {
            override fun loadDataFromDB(): LiveData<PagedList<MovieEntity>> {
                val data = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getLocalMovies(), data).build()
            }

            override fun shouldFetchData(data: PagedList<MovieEntity>?): Boolean =
                data.isNullOrEmpty()


            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovies()

            override fun saveDataCallResult(data: List<MovieResponse>) {
                val movies = ArrayList<MovieEntity>()
                for (movie in data){
                    val itemMovie = MovieEntity(
                        null,
                        movie.movieId,
                        movie.title,
                        movie.description,
                        movie.poster,
                        movie.release,
                        movie.rating,
                        false
                    )
                    movies.add(itemMovie)
                }
                localDataSource.insertLocalMovies(movies)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<DefaultResourceStatus<DetailMovieEntity>> {
        return object : NetworkDispatcherResource<DetailMovieEntity, DetailMovieResponse>(){
            override fun loadDataFromDB(): LiveData<DetailMovieEntity> = localDataSource.getLocalDetailMovie(movieId)

            override fun shouldFetchData(data: DetailMovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveDataCallResult(data: DetailMovieResponse) {
                val movie = DetailMovieEntity(
                    null,
                    data.movieId,
                    data.title,
                    data.description,
                    data.poster,
                    data.release,
                    data.rating,
                    false,
                    data.duration
                )
                localDataSource.insertLocalDetailMovie(movie)
            }

        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<DetailMovieEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun setFavoriteMovie(detailMovieEntity: DetailMovieEntity) {
        CoroutineScope(IO).launch {
            localDataSource.setFavoriteMovie(detailMovieEntity)
        }
    }

}