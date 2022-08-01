package com.projeto.movielist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projeto.movielist.model.movie.MovieResumed
import com.projeto.movielist.R
import com.projeto.movielist.databinding.MovieListItemBinding

class MovieSearchAdapter(
    private val movieItemClick: (movieId: String) -> Unit,
    private var items: List<MovieResumed>
) : RecyclerView.Adapter<MovieSearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieResumed) {
            binding.tvMovieTitle.text = item.title
            Glide.with(itemView.context)
                .load(item.poster)
                .placeholder(R.drawable.movie_placeholder)
                .centerCrop()
                .into(binding.ivMoviePoster)
            binding.cvLayout.setOnClickListener {
                movieItemClick(item.imdbID)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    fun updateList(list: List<MovieResumed>?) {
        if (!list.isNullOrEmpty()) {
            this.items = list
            this.notifyDataSetChanged()
        }
    }
}