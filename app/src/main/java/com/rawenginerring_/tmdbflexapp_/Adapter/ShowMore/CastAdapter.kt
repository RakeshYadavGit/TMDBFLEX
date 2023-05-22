package com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.testing.Credits

class CastAdapter(private val castList: Credits) : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    inner class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textView)
        private val characterTextView: TextView = itemView.findViewById(R.id.character)
        private val profileImageView: ImageView = itemView.findViewById(R.id.circleImageView)

        fun bind(cast: Credits.Cast) {
            nameTextView.text = cast.name
            characterTextView.text = cast.character
            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w185" + cast.profilePath)
                .placeholder(R.drawable.user).into(profileImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person, parent, false)
        return CastViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = castList.cast[position]
        holder.bind(cast)
    }

    override fun getItemCount() = castList.cast.size
}
