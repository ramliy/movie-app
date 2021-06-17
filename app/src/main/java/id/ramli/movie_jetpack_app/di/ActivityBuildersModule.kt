package id.ramli.movie_jetpack_app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ramli.movie_jetpack_app.detail.DetailMovieActivity
import id.ramli.movie_jetpack_app.detail.DetailTvShowActivity
import id.ramli.movie_jetpack_app.home.HomeActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeDetaiMovielActivity(): DetailMovieActivity

    @ContributesAndroidInjector
    abstract fun contributeDetaiTvShowActivity(): DetailTvShowActivity

}