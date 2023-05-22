package com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.testing.Credits

class CrewAdapter(private val crewList: Credits) : RecyclerView.Adapter<CrewAdapter.CrewViewHolder>() {

    inner class CrewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name)
        private val departmentTextView: TextView = itemView.findViewById(R.id.type)

        fun bind(crew: Credits.Crew) {
            nameTextView.text = crew.name
            departmentTextView.text = crew.department
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.crew, parent, false)
        return CrewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
        val crew = crewList.crew[position]
        holder.bind(crew)
    }

    override fun getItemCount() = if (crewList.crew.size > 0) 6 else 0

}
