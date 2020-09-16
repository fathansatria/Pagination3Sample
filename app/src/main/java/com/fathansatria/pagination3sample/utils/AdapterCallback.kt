package com.fathansatria.pagination3sample.utils

import androidx.recyclerview.widget.DiffUtil
import com.fathansatria.pagination3sample.models.MovieModel

object AdapterCallback {

    val diffMovies = object  : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            // Id is unique.
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }
    }
}