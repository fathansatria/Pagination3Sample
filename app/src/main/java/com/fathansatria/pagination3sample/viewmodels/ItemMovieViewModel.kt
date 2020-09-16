package com.fathansatria.pagination3sample.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.fathansatria.pagination3sample.models.MovieModel

class ItemMovieViewModel(model : MovieModel) : ViewModel() {

    var title : ObservableField<String> = ObservableField(model.Title)
    var poster : ObservableField<String> = ObservableField(model.Poster)
    var year : ObservableField<String> = ObservableField(model.Year)

}