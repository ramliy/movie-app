package id.ramli.movie_jetpack_app.data

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import id.ramli.movie_jetpack_app.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()

}