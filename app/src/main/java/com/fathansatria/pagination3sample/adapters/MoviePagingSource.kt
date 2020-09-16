package com.fathansatria.pagination3sample.adapters

import androidx.paging.PagingSource
import com.fathansatria.pagination3sample.models.MovieModel
import com.fathansatria.pagination3sample.networks.rests.RestApi


class MoviePagingSource(private val service: RestApi, private val query: String) : PagingSource<Int, MovieModel>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, MovieModel> {
        try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val response = service.movies(query,nextPageNumber)
            val data = response.Search

            return LoadResult.Page(
                data = data,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
            return LoadResult.Error(e)
        }
    }
}