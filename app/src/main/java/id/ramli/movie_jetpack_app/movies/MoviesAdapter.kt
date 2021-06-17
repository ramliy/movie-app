package id.ramli.movie_jetpack_app.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ramli.movie_jetpack_app.BuildConfig
import id.ramli.movie_jetpack_app.R
import id.ramli.movie_jetpack_app.data.source.movie.MovieEntity
import id.ramli.movie_jetpack_app.databinding.ItemsModelBinding

/**
 * Created by ramliy10 on 04/05/21.
 */
class MoviesAdapter(private val listener: MovieItemClick) :

    PagedListAdapter<MovieEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
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
            listener.onMovieItemClicked(movie)
        }
    }

    class MoviesViewHolder(private val binding: ItemsModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
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


