package com.rawenginerring_.tmdbflexapp_.Adapter

import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.models.MovieModel
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class UpcomingMovieSliderAdapter(private val movies: List<MovieModel>) : SliderAdapter() {

    override fun getItemCount(): Int = movies.size

    override fun onBindImageSlide(position: Int, viewHolder: ImageSlideViewHolder) {
        val movie = movies[position]
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        Glide.with(viewHolder.itemView)
            .load(IMAGE_BASE + movie.poster)
            .into(viewHolder.imageView)
    }

}
