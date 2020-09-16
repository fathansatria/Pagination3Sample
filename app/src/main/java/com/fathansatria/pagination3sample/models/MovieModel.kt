package com.fathansatria.pagination3sample.models

import com.squareup.moshi.Json

data class MovieModel(
    @Json(name = "Title")
    var Title : String,
    @Json(name = "Year")
    var Year : String,
    @Json(name = "Type")
    var Type : String,
    @Json(name = "Poster")
    var Poster : String,
    @Json(name = "imdbID")
    var imdbID : String
) {
}