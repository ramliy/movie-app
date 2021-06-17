package id.ramli.movie_jetpack_app.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import id.ramli.movie_jetpack_app.BuildConfig
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity
import id.ramli.movie_jetpack_app.databinding.ActivityDetailMovieBinding
import id.ramli.movie_jetpack_app.databinding.ContentDetailMovieBinding
import id.ramli.movie_jetpack_app.movies.MovieFactory
import javax.inject.Inject

class DetailMovieActivity : DaggerAppCompatActivity() {

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    @Inject
    lateinit var movieFactory: MovieFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.contentDetailMovie
        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this, movieFactory)[DetailMovieViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val movieId = intent.getIntExtra(EXTRA_MOVIE, 0)
            viewModel.getMovieDetail(movieId).observe(this, Observer { detailMovie ->
                detailMovie.data?.let { bindMovie(it) }
            })
        }

    }

    private fun bindMovie(detailMovie: DetailMovieEntity) {
        detailMovieBinding.tvTitle.text = detailMovie.title
        detailMovieBinding.tvDuration.text = StringBuilder(detailMovie.duration).append(" minutes")
        detailMovieBinding.tvRating.text = StringBuilder(detailMovie.rating).append("/10")
        detailMovieBinding.tvRelease.text = detailMovie.release
        detailMovieBinding.tvDescription.text = detailMovie.description

        if (detailMovie.isFavorite) {
            detailMovieBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_red)
        } else detailMovieBinding.fabFavorite.setImageResource(R.drawable.ic_favorite)

        detailMovieBinding.fabFavorite.setOnClickListener { setFavoriteMovie(detailMovie) }

        Glide.with(this)
            .load(BuildConfig.IMAGE_URL + detailMovie.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailMovieBinding.imagePoster)
    }

    private fun setFavoriteMovie(detailMovie: DetailMovieEntity) {
        if (detailMovie.isFavorite){
            showSnackBar("${detailMovie.title} Removed from favorites")
        }else{
            showSnackBar("${detailMovie.title} Added to favorites")
        }
        viewModel.setMovieFavorite(detailMovie)
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}