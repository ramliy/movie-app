package id.ramli.movie_jetpack_app.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.data.source.movie.MovieRepository
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository
import id.ramli.movie_jetpack_app.movies.MovieViewModel
import id.ramli.movie_jetpack_app.tv_shows.TvShowsViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var movieViewModel : MovieViewModel
    private lateinit var tvShowViewModel: TvShowsViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository
    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerMovies: Observer<PagedList<DetailMovieEntity>>
    @Mock
    private lateinit var observerTvShows: Observer<PagedList<DetailTvShowEntity>>

    @Mock
    private lateinit var moviesPagedList: PagedList<DetailMovieEntity>
    @Mock
    private lateinit var tvShowsPagedList: PagedList<DetailTvShowEntity>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(movieRepository)
        tvShowViewModel = TvShowsViewModel(tvShowRepository)
    }

    @Test
    fun getFavoritesMovies(){
        val dummyMoviesFavorites = moviesPagedList
        Mockito.`when`(dummyMoviesFavorites.size).thenReturn(3)
        val movie = MutableLiveData<PagedList<DetailMovieEntity>>()
        movie.value = dummyMoviesFavorites

        Mockito.`when`(movieRepository.getFavoriteMovies()).thenReturn(movie)
        val movieEntity = movieViewModel.getFavoriteMovies().value
        Mockito.verify(movieRepository).getFavoriteMovies()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(3, movieEntity?.size)

        movieViewModel.getFavoriteMovies().observeForever(observerMovies)
        Mockito.verify(observerMovies).onChanged(dummyMoviesFavorites)
    }

    @Test
    fun getFavoritesTvShows(){
        val dummyTvShowsFavorites = tvShowsPagedList
        Mockito.`when`(dummyTvShowsFavorites.size).thenReturn(3)
        val tvShows = MutableLiveData<PagedList<DetailTvShowEntity>>()
        tvShows.value = dummyTvShowsFavorites

        Mockito.`when`(tvShowRepository.getFavoriteTvShows()).thenReturn(tvShows)
        val tvShowEntity = tvShowViewModel.getFavoriteTvShows().value
        Mockito.verify(tvShowRepository).getFavoriteTvShows()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(3, tvShowEntity?.size)

        tvShowViewModel.getFavoriteTvShows().observeForever(observerTvShows)
        Mockito.verify(observerTvShows).onChanged(dummyTvShowsFavorites)
    }

}