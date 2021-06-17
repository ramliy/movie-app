package id.ramli.movie_jetpack_app.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val appDao: AppDao) {

    fun insertLocalMovies(movies: List<MovieEntity>) = appDao.insertMovie(movies)
    fun getLocalMovies() : DataSource.Factory<Int, MovieEntity> = appDao.getLocalMovies()
    fun insertLocalDetailMovie(movie: DetailMovieEntity) = appDao.insertDetailMovie(movie)
    fun getLocalDetailMovie(movieId: Int) : LiveData<DetailMovieEntity> = appDao.getDetailMovieById(movieId)

    fun insertLocalTvShows(tvShows: List<TvShowEntity>) = appDao.insertTvShow(tvShows)
    fun getLocalTvShows() : DataSource.Factory<Int, TvShowEntity> = appDao.getLocalTvShows()
    fun insertLocalDetailTvShow(tvShow: DetailTvShowEntity) = appDao.insertDetailTvShow(tvShow)
    fun getLocalDetailTvShow(tvShowId: Int) : LiveData<DetailTvShowEntity> = appDao.getDetailTvShowById(tvShowId)

    fun getFavoriteMovies() : DataSource.Factory<Int, DetailMovieEntity> = appDao.getFavoriteMovies()
    fun setFavoriteMovie(detailMovieEntity: DetailMovieEntity) {
        detailMovieEntity.isFavorite = !detailMovieEntity.isFavorite
        appDao.updateMovie(detailMovieEntity)
    }

    fun getFavoriteTvShows() : DataSource.Factory<Int, DetailTvShowEntity> = appDao.getFavoriteTvShows()
    fun setFavoriteTvShow(detailTvShowEntity: DetailTvShowEntity) {
        detailTvShowEntity.isFavorite = !detailTvShowEntity.isFavorite
        appDao.updateTvShow(detailTvShowEntity)
    }
}