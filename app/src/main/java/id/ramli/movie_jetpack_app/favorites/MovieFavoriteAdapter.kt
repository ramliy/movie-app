package id.ramli.movie_jetpack_app.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ramli.movie_jetpack_app.BuildConfig
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.data.source.movie.DetailMovieEntity

import id.ramli.movie_jetpack_app.databinding.ItemsModelBinding

class MovieFavoriteAdapter (private val listener: MovieFavoriteItemClick) :

    PagedListAdapter<DetailMovieEntity, MovieFavoriteAdapter.MoviesViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DetailMovieEntity>() {
            override fun areItemsTheSame(oldItem: DetailMovieEntity, newItem: DetailMovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: DetailMovieEntity, newItem: DetailMovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsModelBinding =
            ItemsModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsModelBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie!!)
        holder.itemView.setOnClickListener {
            listener.onMovieFavoriteItemClicked(movie)
        }
    }

    class MoviesViewHolder(private val binding: ItemsModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DetailMovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDescription.text = movie.description
                tvItemDate.text = movie.release
                Glide.with(itemView.context)
                    .load(BuildConfig.IMAGE_URL + movie.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                            .centerCrop()
                    )
                    .into(imgPoster)

            }
        }
    }
}


