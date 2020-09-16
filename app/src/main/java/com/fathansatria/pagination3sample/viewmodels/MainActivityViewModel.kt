package com.fathansatria.pagination3sample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fathansatria.pagination3sample.models.MovieModel
import com.fathansatria.pagination3sample.networks.repositories.MovieRepositories
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel(var repositories: MovieRepositories) : ViewModel() {

    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<MovieModel>>? = null

    fun searchMovie(queryString: String): Flow<PagingData<MovieModel>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        currentQueryValue = queryString
        val newResult: Flow<PagingData<MovieModel>> = repositories.getResultStream(queryString)
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}