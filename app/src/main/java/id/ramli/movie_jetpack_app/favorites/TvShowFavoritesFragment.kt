package id.ramli.movie_jetpack_app.favorites

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.databinding.FragmentTvShowFavoritesBinding
import id.ramli.movie_jetpack_app.detail.DetailTvShowActivity
import id.ramli.movie_jetpack_app.tv_shows.TvShowFactory
import id.ramli.movie_jetpack_app.tv_shows.TvShowsViewModel
import javax.inject.Inject


class TvShowFavoritesFragment : DaggerFragment(), TvShowFavoriteItemClick {
    private var _fragmentTvShowFavoriteBinding: FragmentTvShowFavoritesBinding? = null
    private val binding get() = _fragmentTvShowFavoriteBinding

    @Inject
    lateinit var tvShowFactory: TvShowFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentTvShowFavoriteBinding = FragmentTvShowFavoritesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel =
                ViewModelProvider(this, tvShowFactory)[TvShowsViewModel::class.java]
            val tvShowAdapter = TvShowFavoriteAdapter(this)
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, Observer { movies ->
                if (movies!=null){
                    when(tvShowAdapter){
                        is TvShowFavoriteAdapter -> {
                            if (movies.isNullOrEmpty()){
                                binding!!.rvTvShowsFavorite.visibility = View.GONE
                            } else {
                                binding!!.rvTvShowsFavorite.visibility = View.VISIBLE
                                tvShowAdapter.submitList(movies)
                                tvShowAdapter.notifyDataSetChanged()
                            }
                        }
                    }
                }

                with(binding?.rvTvShowsFavorite) {
                    this?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                    this?.setHasFixedSize(true)
                    this?.adapter = tvShowAdapter
                }
            })

        }
    }

    override fun onTvShowFavoriteItemCLicked(detailTvShowEntity: DetailTvShowEntity) {
        val intent = Intent(context, DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, detailTvShowEntity.tvShowId)
        startActivity(intent)
    }
}