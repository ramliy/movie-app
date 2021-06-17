package id.ramli.movie_jetpack_app.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.ramli.movie_jetpack_app.LiveDataTestUtil
import id.ramli.movie_jetpack_app.PagedListUtil
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.local.LocalDataSource
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.data.source.remote.RemoteDataSource
import id.ramli.movie_jetpack_app.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote, local)
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyDetailMovie = DataDummy.generateDummyDetailMovie()
    private val movieId = dummyDetailMovie.movieId

    @Test
    fun getMovies(){
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getLocalMovies()).thenReturn(dataSource)
        movieRepository.getMovies()

        val movieEntity = DefaultResourceStatus.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        Mockito.verify(local).getLocalMovies()
        assertNotNull(movieEntity.data)
        assertEquals(dummyMovies.size.toLong(), movieEntity.data?.size?.toLong())

    }

    @Test
    fun getDetailMovie(){
        val dummyMovie = MutableLiveData<DetailMovieEntity>()
        dummyMovie.value = dummyDetailMovie
        Mockito.`when`(local.getLocalDetailMovie(movieId!!)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))
        Mockito.verify(local).getLocalDetailMovie(movieId)
        assertNotNull(data)
        assertEquals(dummyDetailMovie.movieId, movieId)

    }

    @Test
    fun getFavoriteMovies(){
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DetailMovieEntity>
        Mockito.`when`(local.getFavoriteMovies()).thenReturn(dataSource)
        movieRepository.getFavoriteMovies()

        val movieEntity = DefaultResourceStatus.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        Mockito.verify(local).getFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(dummyMovies.size.toLong(), movieEntity.data?.size?.toLong())
    }

}