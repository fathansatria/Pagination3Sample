package com.fathansatria.pagination3sample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fathansatria.pagination3sample.databinding.ItemMovieBinding
import com.fathansatria.pagination3sample.models.MovieModel
import com.fathansatria.pagination3sample.viewmodels.ItemMovieViewModel

class MovieViewHolder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model : MovieModel){
        binding.movie = ItemMovieViewModel(model)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MovieViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemMovieBinding.inflate(inflater, parent, false)
            return MovieViewHolder(binding)
        }
    }

}