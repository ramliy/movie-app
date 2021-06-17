package id.ramli.movie_jetpack_app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ramli.movie_jetpack_app.favorites.MovieFavoritesFragment
import id.ramli.movie_jetpack_app.favorites.TvShowFavoritesFragment

@Module
abstract class FavoriteFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieFavoriteFragment() : MovieFavoritesFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFavoriteFragment() : TvShowFavoritesFragment
}