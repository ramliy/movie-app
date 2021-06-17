package id.ramli.movie_jetpack_app.tv_shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository
import id.ramli.movie_jetpack_app.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by ramliy10 on 22/05/21.
 */
@RunWith(MockitoJUnitRunner::class)
class TvShowsViewModelTest {

    private val dummyTvShows = DataDummy.generateDummyTvShows()
    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowsRepository: TvShowRepository

    @Mock
    private lateinit var observer: Observer<DefaultResourceStatus<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp(){
        viewModel = TvShowsViewModel(tvShowsRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = DefaultResourceStatus.success(pagedList)
        Mockito.`when`(dummyTvShows.data?.size).thenReturn(5)
        val tvShows = MutableLiveData<DefaultResourceStatus<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShows

        Mockito.`when`(tvShowsRepository.getTvShows()).thenReturn(tvShows)
        val movieEntity = viewModel.getTvShows().value?.data
        Mockito.verify(tvShowsRepository).getTvShows()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(5, movieEntity?.size)

        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)

    }
}