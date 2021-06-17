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
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.databinding.ActivityDetailTvShowBinding
import id.ramli.movie_jetpack_app.databinding.ContentDetailTvShowBinding
import id.ramli.movie_jetpack_app.tv_shows.TvShowFactory
import javax.inject.Inject

class DetailTvShowActivity : DaggerAppCompatActivity() {

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    @Inject
    lateinit var tvShowFactory: TvShowFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.contentDetailTvShow
        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this, tvShowFactory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = intent.getIntExtra(EXTRA_TV_SHOW, 0)
            viewModel.getTvShowDetail(tvShowId).observe(this, Observer { detailTvShow ->
                detailTvShow.data?.let { bindTvShow(it) }
            })
        }

    }

    private fun bindTvShow(detailTvShow: DetailTvShowEntity) {
        detailTvShowBinding.tvTitle.text = detailTvShow.title

        detailTvShowBinding.tvStatus.text = detailTvShow.status
        detailTvShowBinding.tvRating.text = StringBuilder(detailTvShow.rating).append("/10")
        detailTvShowBinding.tvRelease.text = detailTvShow.release
        detailTvShowBinding.tvDescription.text = detailTvShow.description

        if (detailTvShow.isFavorite) {
            detailTvShowBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_red)
        } else detailTvShowBinding.fabFavorite.setImageResource(R.drawable.ic_favorite)

        Glide.with(this)
            .load(BuildConfig.IMAGE_URL + detailTvShow.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailTvShowBinding.imagePoster)

        detailTvShowBinding.fabFavorite.setOnClickListener { setFavoriteTvShow(detailTvShow) }

    }

    private fun setFavoriteTvShow(detailTvShow: DetailTvShowEntity) {
        if (detailTvShow.isFavorite) {
            showSnackBar("${detailTvShow.title} Removed from favorites")
        } else {
            showSnackBar("${detailTvShow.title} Added to favorites")
        }
        viewModel.setTvShowFavorite(detailTvShow)
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
}