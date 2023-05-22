package com.rawenginerring_.tmdbflexapp_.db.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.R

class BookmarkAdapter(private val bookmarks: List<Bookmark>) :
    RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.similar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = bookmarks[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return bookmarks.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieName: TextView = itemView.findViewById(R.id.textView3)
        private val movieImage: ImageView = itemView.findViewById(R.id.poster)
        private val movieRating: TextView = itemView.findViewById(R.id.textView4)
        private val movieYear: TextView = itemView.findViewById(R.id.textView2)

        fun bind(item: Bookmark) {

                    movieName.text = item.title
                    val IMAGE_BASE = "https://image.tmdb.org/t/p/w185/"
                    Glide.with(itemView)
                        .load(IMAGE_BASE + item.posterUrl)
                        .into(movieImage)

                    movieRating.text = item.rating.toString()
                    movieYear.text = item.year
                }

    }
}
