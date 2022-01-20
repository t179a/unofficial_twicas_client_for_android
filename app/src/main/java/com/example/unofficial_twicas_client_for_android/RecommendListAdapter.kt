package com.example.unofficial_twicas_client_for_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.unofficial_twicas_client_for_android.databinding.RecommendListViewItemBinding

class RecommendListAdapter : ListAdapter<RecommendMovieProperty, RecommendListAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RecommendListViewItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: RecommendMovieProperty) {
            binding.recommendMovieProperty = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecommendListViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class SleepNightDiffCallback : DiffUtil.ItemCallback<RecommendMovieProperty>() {

    override fun areItemsTheSame(oldItem: RecommendMovieProperty, newItem: RecommendMovieProperty): Boolean {
        return oldItem.movie.id == newItem.movie.id
    }


    override fun areContentsTheSame(oldItem: RecommendMovieProperty, newItem: RecommendMovieProperty): Boolean {
        return oldItem == newItem
    }


}