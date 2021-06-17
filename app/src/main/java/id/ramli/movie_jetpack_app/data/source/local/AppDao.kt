package id.ramli.movie_jetpack_app.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity

@Dao
interface AppDao {

    @Query("SELECT * FROM tb_movie")
    fun getLocalMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tb_tvShow")
    fun getLocalTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM  tb_detail_movie WHERE isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, DetailMovieEntity>

    @Query("SELECT * FROM tb_detail_tvShow WHERE isFavorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, DetailTvShowEntity>

    @Query("SELECT * FROM tb_detail_movie WHERE movieId = :movieId")
    fun getDetailMovieById(movieId: Int): LiveData<DetailMovieEntity>

    @Query("SELECT * FROM tb_detail_tvShow WHERE tvShowId = :tvShowId")
    fun getDetailTvShowById(tvShowId: Int): LiveData<DetailTvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovie(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = DetailMovieEntity::class)
    fun insertDetailMovie(movie: DetailMovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowEntity::class)
    fun insertTvShow(tvShows: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = DetailTvShowEntity::class)
    fun insertDetailTvShow(tvShow: DetailTvShowEntity)

    @Update(entity = DetailMovieEntity::class)
    fun updateMovie(detailMovieEntity: DetailMovieEntity)

    @Update(entity = DetailTvShowEntity::class)
    fun updateTvShow(tvShows: DetailTvShowEntity)

}