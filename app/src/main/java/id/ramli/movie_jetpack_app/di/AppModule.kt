package id.ramli.movie_jetpack_app.di

import android.app.Application
import dagger.Module
import dagger.Provides
import id.ramli.movie_jetpack_app.data.source.local.AppDao
import id.ramli.movie_jetpack_app.data.source.local.AppDatabase
import id.ramli.movie_jetpack_app.data.source.local.LocalDataSource
import id.ramli.movie_jetpack_app.data.source.movie.MovieRepository
import id.ramli.movie_jetpack_app.data.source.remote.ApiService
import id.ramli.movie_jetpack_app.data.source.remote.RemoteDataSource
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowRepository
import id.ramli.movie_jetpack_app.movies.MovieFactory
import id.ramli.movie_jetpack_app.tv_shows.TvShowFactory
import javax.inject.Singleton

/**
 * Created by ramliy10 on 05/06/21.
 */
@Module
class AppModule {
    companion object {

        @Singleton
        @Provides
        fun provideAppDatabase(application: Application): AppDatabase =
            AppDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideAppDao(appDatabase: AppDatabase): AppDao =
            appDatabase.appDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(appDao: AppDao): LocalDataSource =
            LocalDataSource(appDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideMovieRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ):
                MovieRepository = MovieRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideTvShowRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource):
                TvShowRepository = TvShowRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideMovieViewModelFactory(movieRepository: MovieRepository): MovieFactory =
            MovieFactory(movieRepository)

        @Singleton
        @Provides
        fun provideTvShowViewModelFactory(tvShowRepository: TvShowRepository): TvShowFactory =
            TvShowFactory(tvShowRepository)


    }
}