package id.ramli.movie_jetpack_app.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.data.source.Status
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.databinding.FragmentMoviesBinding
import id.ramli.movie_jetpack_app.detail.DetailMovieActivity
import javax.inject.Inject

class MoviesFragment : DaggerFragment(), MovieItemClick {

    private var _fragmentMovieBinding: FragmentMoviesBinding? = null
    private val binding get() = _fragmentMovieBinding

    @Inject
    lateinit var movieFactory: MovieFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentMovieBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val viewModel =
                ViewModelProvider(this, movieFactory)[MovieViewModel::class.java]

            val movieAdapter = MoviesAdapter(this)
            viewModel.getMovies().observe(viewLifecycleOwner, Observer { movies ->
                when (movies.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        movieAdapter.submitList(movies.data)
                        movieAdapter.notifyDataSetChanged()

                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Error Occurs", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            with(binding?.rvMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }

    }

    override fun onMovieItemClicked(movieEntity: MovieEntity) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movieEntity.movieId)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentMovieBinding = null
    }


}