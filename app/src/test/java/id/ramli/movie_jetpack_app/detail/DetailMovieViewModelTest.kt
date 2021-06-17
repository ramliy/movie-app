package id.ramli.movie_jetpack_app.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by ramliy10 on 18/05/21.
 */
@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<DefaultResourceStatus<DetailMovieEntity>>

    @Mock
    private lateinit var data: DetailMovieEntity

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel(movieRepository)
    }

    @Test
    fun getDetailMovie(){

        val dummyDetailMovie = DefaultResourceStatus.success(data)

        val movie = MutableLiveData<DefaultResourceStatus<DetailMovieEntity>>()
        movie.value = dummyDetailMovie
        Mockito.`when`(movieRepository.getDetailMovie(dummyDetailMovie.data?.movieId!!)).thenReturn(movie)

        val movieData = viewModel.getMovieDetail(dummyDetailMovie.data?.movieId!!).value as DefaultResourceStatus<DetailMovieEntity>

        assertNotNull(movieData)
        assertEquals(dummyDetailMovie.data?.movieId, movieData.data?.movieId)
        assertEquals(dummyDetailMovie.data?.title, movieData.data?.title)
        assertEquals(dummyDetailMovie.data?.description, movieData.data?.description)
        assertEquals(dummyDetailMovie.data?.poster, movieData.data?.poster)
        assertEquals(dummyDetailMovie.data?.release, movieData.data?.release)
        assertEquals(dummyDetailMovie.data?.rating, movieData.data?.rating)
        assertEquals(dummyDetailMovie.data?.duration, movieData.data?.duration)

        viewModel.getMovieDetail(dummyDetailMovie.data?.movieId!!).observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

}