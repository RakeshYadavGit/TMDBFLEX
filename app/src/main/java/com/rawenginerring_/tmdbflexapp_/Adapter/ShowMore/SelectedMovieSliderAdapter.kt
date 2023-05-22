package com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore

import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.testing.MovieInfo
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class SelectedMovieSliderAdapter(private val movie: MovieInfo) : SliderAdapter() {

    override fun getItemCount(): Int = 2

    override fun onBindImageSlide(position: Int, viewHolder: ImageSlideViewHolder) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        Glide.with(viewHolder.itemView)
            .load(IMAGE_BASE + movie.posterPath)
            .into(viewHolder.imageView)

    }
}
