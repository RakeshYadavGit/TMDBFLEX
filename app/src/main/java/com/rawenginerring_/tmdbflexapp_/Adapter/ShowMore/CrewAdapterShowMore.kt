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

class CrewAdapterShowMore(private val crewList: Credits) : RecyclerView.Adapter<CrewAdapterShowMore.CrewViewHolder>() {

    inner class CrewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textView)
        private val characterTextView: TextView = itemView.findViewById(R.id.character)
        private val profileImageView: ImageView = itemView.findViewById(R.id.circleImageView)

        fun bind(crew: Credits.Crew) {
            nameTextView.text = crew.name
            characterTextView.text = crew.department
            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w185" + crew.profilePath)
                .placeholder(R.drawable.user).into(profileImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person, parent, false)
        return CrewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
        val crew = crewList.crew[position]
        holder.bind(crew)
    }

    override fun getItemCount(): Int {
        return crewList.crew.size
    }
}
