package com.projeto.movielist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projeto.common.model.movie.Movie
import com.projeto.movielist.R
import com.projeto.movielist.databinding.MovieListItemBinding

class MovieSearchAdapter(
    private var items: List<Movie>
) : RecyclerView.Adapter<MovieSearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.tvMovieTitle.text = item.title
            Glide.with(itemView.context)
                .load(item.poster)
                .placeholder(R.drawable.movie_placeholder)
                .centerCrop()
                .into(binding.ivMoviePoster)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    fun updateList(list: List<Movie>?) {
        if (!list.isNullOrEmpty()) {
            this.items = list
            this.notifyDataSetChanged()
        }
    }
}