package com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.databinding.PersonBinding
import com.rawenginerring_.tmdbflexapp_.testing.Result
import com.rawenginerring_.tmdbflexapp_.testing.Search

class PeopleAdapter(private val people: Search) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(people.results[position])
    }

    override fun getItemCount(): Int {
        return people.results.size
    }

    inner class ViewHolder(private val binding: PersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textView)
        private val knowFor: TextView = itemView.findViewById(R.id.character)
        private val profileImageView: ImageView = itemView.findViewById(R.id.circleImageView)

        fun bind(search: Result) {
            nameTextView.text = search.name
            knowFor.text = search.known_for_department
            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w185" + search.posterPath)
                .placeholder(R.drawable.user).into(profileImageView)
        }
    }
}
