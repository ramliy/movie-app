package id.ramli.movie_jetpack_app.favorites

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.databinding.FragmentMovieFavoritesBinding
import id.ramli.movie_jetpack_app.detail.DetailMovieActivity
import id.ramli.movie_jetpack_app.movies.MovieFactory
import id.ramli.movie_jetpack_app.movies.MovieViewModel
import javax.inject.Inject

class MovieFavoritesFragment  : DaggerFragment(), MovieFavoriteItemClick {

    private var _fragmentMovieFavoriteBinding: FragmentMovieFavoritesBinding? = null
    private val binding get() = _fragmentMovieFavoriteBinding

    @Inject
    lateinit var movieFactory: MovieFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentMovieFavoriteBinding = FragmentMovieFavoritesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel =
                ViewModelProvider(this, movieFactory)[MovieViewModel::class.java]
            val movieAdapter = MovieFavoriteAdapter(this)
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, Observer { movies ->
                if (movies!=null){
                    when(movieAdapter){
                        is MovieFavoriteAdapter -> {
                            if (movies.isNullOrEmpty()){
                                binding?.rvMovieFavorite?.visibility = View.GONE
                            } else {
                                binding?.rvMovieFavorite?.visibility = View.VISIBLE
                                movieAdapter.submitList(movies)
                                movieAdapter.notifyDataSetChanged()
                            }
                        }
                    }
                }

                with(binding?.rvMovieFavorite) {
                    this?.layoutManager = LinearLayoutManager(context)
                    this?.setHasFixedSize(true)
                    this?.adapter = movieAdapter
                }
            })

        }
    }


    override fun onMovieFavoriteItemClicked(detailMovieEntity: DetailMovieEntity) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, detailMovieEntity.movieId)
        startActivity(intent)
    }
}