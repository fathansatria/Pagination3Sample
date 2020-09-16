package com.fathansatria.pagination3sample.networks.rests

import com.fathansatria.pagination3sample.models.MovieModel
import com.fathansatria.pagination3sample.networks.basemodels.ApiServiceModelList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("?i=tt3896198&apikey=f57ab815")
    suspend fun movies(
        @Query("s") search: String,
        @Query("page") page: Int
    ): ApiServiceModelList<MovieModel>

}