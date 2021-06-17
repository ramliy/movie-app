package id.ramli.movie_jetpack_app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ramli.movie_jetpack_app.favorites.FavoriteFragment
import id.ramli.movie_jetpack_app.home.HomeFragment
import id.ramli.movie_jetpack_app.movies.MoviesFragment
import id.ramli.movie_jetpack_app.tv_shows.TvShowsFragment

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment(): TvShowsFragment

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteFragment(): FavoriteFragment
}