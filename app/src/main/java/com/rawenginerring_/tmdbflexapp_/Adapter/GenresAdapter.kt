package com.rawenginerring_.tmdbflexapp_.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rawenginerring_.tmdbflexapp_.databinding.GenreBinding
import com.rawenginerring_.tmdbflexapp_.testing.MovieInfo

class GenresAdapter(private val movie: MovieInfo) : RecyclerView.Adapter<GenresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genres = movie.genres!![position]
        holder.bind(genres)
    }

    override fun getItemCount(): Int {
        return movie.genres!!.size
    }

    inner class ViewHolder(private val binding: GenreBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(genreName: MovieInfo.Genre) {
            binding.description.text = genreName.name
        }
    }
}
