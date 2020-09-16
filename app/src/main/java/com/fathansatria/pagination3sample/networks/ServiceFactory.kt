package com.fathansatria.pagination3sample.networks



import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {

    private fun retrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()

        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logging)
        clientBuilder.callTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }

    fun <T> getApiService(service:Class<T>):T {
        return retrofitInstance().create(service)
    }
}