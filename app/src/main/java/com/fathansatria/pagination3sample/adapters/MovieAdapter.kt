package com.fathansatria.pagination3sample.adapters

import android.util.Log
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.fathansatria.pagination3sample.models.MovieModel
import com.fathansatria.pagination3sample.utils.AdapterCallback

class MovieAdapter() : PagingDataAdapter<MovieModel, MovieViewHolder>(AdapterCallback.diffMovies) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MovieViewHolder {
    return MovieViewHolder.from(parent)
  }

  override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    val item = getItem(position)
    if(item != null){
      holder.bind(item)
      Log.i("TIDAK", "TIDAKNULL")
    }
    else{
      Log.i("TIDAK", "NULL")
    }

  }

}