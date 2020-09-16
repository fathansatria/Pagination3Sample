package com.fathansatria.pagination3sample.networks.basemodels

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
class ApiServiceModelList<T>(
    @Json(name="totalResults")
    val totalResults: Int,
    @Json(name = "Response")
    val Response : String,
    @Json(name="Search")
    val Search: MutableList<T>
) {
}