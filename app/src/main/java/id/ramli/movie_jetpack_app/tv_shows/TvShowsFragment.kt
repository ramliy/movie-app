package id.ramli.movie_jetpack_app.tv_shows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.data.source.Status
import id.ramli.movie_jetpack_app.data.source.tv_show.TvShowEntity
import id.ramli.movie_jetpack_app.databinding.FragmentTvShowsBinding
import id.ramli.movie_jetpack_app.detail.DetailTvShowActivity
import javax.inject.Inject

class TvShowsFragment : DaggerFragment(), TvShowItemClick {

    private var _fragmentTvShowBinding: FragmentTvShowsBinding? = null
    private val binding get() = _fragmentTvShowBinding

    @Inject
    lateinit var tvShowFactory: TvShowFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentTvShowBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel =
                ViewModelProvider(this, tvShowFactory)[TvShowsViewModel::class.java]

            val tvShowAdapter = TvShowsAdapter(this)
            viewModel.getTvShows().observe(viewLifecycleOwner, Observer { tvShows ->
                when (tvShows.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        tvShowAdapter.submitList(tvShows.data)
                        tvShowAdapter.notifyDataSetChanged()

                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Error Occurs", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            with(binding?.rvTvShows) {
                this?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tvShowAdapter
            }

        }
    }

    override fun onTvShowItemCLicked(tvShowEntity: TvShowEntity) {
        val intent = Intent(context, DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShowEntity.tvShowId)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentTvShowBinding = null
    }

}