package id.ramli.movie_jetpack_app.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.databinding.FragmentFavoriteBinding
import id.ramli.movie_jetpack_app.home.SectionsPagerAdapter

class FavoriteFragment : DaggerFragment() {

    private var _fragmentFavoriteBinding: FragmentFavoriteBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sectionsPagerAdapter = context?.let { SectionsPagerAdapter(it, childFragmentManager) }
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)
        binding?.titleToolbar?.text = resources.getText(R.string.bookmark)
    }

}