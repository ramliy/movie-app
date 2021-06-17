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
import id.ramli.movie_jetpack_app.data.source.tv_show.DetailTvShowEntity
import id.ramli.movie_jetpack_app.databinding.ItemsModelBinding


class TvShowFavoriteAdapter (private val listener: TvShowFavoriteItemClick) :
    PagedListAdapter<DetailTvShowEntity, TvShowFavoriteAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DetailTvShowEntity>() {
            override fun areItemsTheSame(oldItem: DetailTvShowEntity, newItem: DetailTvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: DetailTvShowEntity, newItem: DetailTvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val itemsModelBinding =
            ItemsModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsModelBinding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShows = getItem(position)
        holder.bind(tvShows!!)
        holder.itemView.setOnClickListener {
            listener.onTvShowFavoriteItemCLicked(tvShows)
        }
    }

    class TvShowsViewHolder(private val binding: ItemsModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: DetailTvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDescription.text = tvShow.description
                tvItemDate.text = tvShow.release

                Glide.with(itemView.context)
                    .load(BuildConfig.IMAGE_URL + tvShow.poster)
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

