package com.rawenginerring_.tmdbflexapp_.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.models.MovieModel

class ImagePagerAdapter(private val movies: List<MovieModel>) : PagerAdapter() {

    override fun getCount(): Int = movies.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context).inflate(R.layout.item_image_pager, container, false)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

        val movie = movies[position]
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        Glide.with(container)
            .load(IMAGE_BASE + movie.backdropPath)
            .into(imageView)

        container.addView(itemView)

        return itemView
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
