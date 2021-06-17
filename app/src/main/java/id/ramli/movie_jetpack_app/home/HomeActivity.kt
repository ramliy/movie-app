package id.ramli.movie_jetpack_app.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.android.support.DaggerAppCompatActivity
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.favorites.FavoriteFragment
import id.ramli.movie_jetpack_app.movies.MoviesFragment
import id.ramli.movie_jetpack_app.tv_shows.TvShowsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : DaggerAppCompatActivity() {

    private lateinit var fragment: Fragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment()).commit()
        bottom_navbar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_movie -> fragment = HomeFragment()
                R.id.menu_bookmarks -> fragment = FavoriteFragment()
            }
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment).commit()
            true
        }


    }
}