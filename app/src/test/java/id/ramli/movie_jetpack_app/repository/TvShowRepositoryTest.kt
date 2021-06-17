package id.ramli.movie_jetpack_app.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.ramli.movie_jetpack_app.LiveDataTestUtil
import id.ramli.movie_jetpack_app.PagedListUtil
import id.ramli.movie_jetpack_app.data.source.DefaultResourceStatus
import id.ramli.movie_jetpack_app.data.source.local.LocalDataSource
import id.ramli.movie_jetpack_app.data.source.remote.RemoteDataSource
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity
import id.ramli.movie_jetpack_app.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class TvShowRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val tvShowRepository = FakeTvShowRepository(remote, local)
    private val dummyTvShows = DataDummy.generateDummyTvShows()
    private val dummyDetailTvShow = DataDummy.generateDummyDetailTvShow()
    private val tvShowId = dummyDetailTvShow.tvShowId

    @Test
    fun getTvShows(){
        val dataSource = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        Mockito.`when`(local.getLocalTvShows()).thenReturn(dataSource)
        tvShowRepository.getTvShows()

        val tvShowEntity = DefaultResourceStatus.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        Mockito.verify(local).getLocalTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(dummyTvShows.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getDetaiTvShow(){
        val dummyTvShow = MutableLiveData<DetailTvShowEntity>()
        dummyTvShow.value = dummyDetailTvShow
        Mockito.`when`(local.getLocalDetailTvShow(tvShowId!!)).thenReturn(dummyTvShow)

        val data = LiveDataTestUtil.getValue(tvShowRepository.getDetailTvShow(tvShowId))
        Mockito.verify(local).getLocalDetailTvShow(tvShowId)
        assertNotNull(data)
        assertEquals(dummyDetailTvShow.tvShowId, tvShowId)
    }

    @Test
    fun getFavoriteTvShow(){
        val dataSource = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DetailTvShowEntity>
        Mockito.`when`(local.getFavoriteTvShows()).thenReturn(dataSource)
        tvShowRepository.getFavoriteTvShows()

        val movieEntity = DefaultResourceStatus.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        Mockito.verify(local).getFavoriteTvShows()
        assertNotNull(movieEntity.data)
        assertEquals(dummyTvShows.size.toLong(), movieEntity.data?.size?.toLong())

    }
}