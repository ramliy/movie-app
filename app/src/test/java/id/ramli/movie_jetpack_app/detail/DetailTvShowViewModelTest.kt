package id.ramli.movie_jetpack_app.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository
import id.ramli.movie_jetpack_app.utils.DataDummy
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
 * Created by ramliy10 on 23/05/21.
 */
@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    @Mock
    private lateinit var observer: Observer<DefaultResourceStatus<DetailTvShowEntity>>

    @Mock
    private lateinit var data: DetailTvShowEntity


    @Before
    fun setUp(){
        viewModel = DetailTvShowViewModel(tvShowRepository)
    }

    @Test
    fun getDetailTvShow(){
        val dummyDetailTvShow = DefaultResourceStatus.success(data)

        val tvShow = MutableLiveData<DefaultResourceStatus<DetailTvShowEntity>>()
        tvShow.value = dummyDetailTvShow
        Mockito.`when`(tvShowRepository.getDetailTvShow(dummyDetailTvShow.data?.tvShowId!!)).thenReturn(tvShow)

        val movieData = viewModel.getTvShowDetail(dummyDetailTvShow.data?.tvShowId!!).value as DefaultResourceStatus<DetailTvShowEntity>

        assertNotNull(movieData)
        assertEquals(dummyDetailTvShow.data?.tvShowId, movieData.data?.tvShowId)
        assertEquals(dummyDetailTvShow.data?.title, movieData.data?.title)
        assertEquals(dummyDetailTvShow.data?.description, movieData.data?.description)
        assertEquals(dummyDetailTvShow.data?.poster, movieData.data?.poster)
        assertEquals(dummyDetailTvShow.data?.release, movieData.data?.release)
        assertEquals(dummyDetailTvShow.data?.rating, movieData.data?.rating)
        assertEquals(dummyDetailTvShow.data?.status, movieData.data?.status)

        viewModel.getTvShowDetail(dummyDetailTvShow.data?.tvShowId!!).observeForever(observer)
        verify(observer).onChanged(dummyDetailTvShow)

    }
}