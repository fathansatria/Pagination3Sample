
package com.fathansatria.pagination3sample.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fathansatria.pagination3sample.networks.repositories.MovieRepositories
import com.fathansatria.pagination3sample.viewmodels.MainActivityViewModel


class ViewModelFactory(private val repository: MovieRepositories) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
