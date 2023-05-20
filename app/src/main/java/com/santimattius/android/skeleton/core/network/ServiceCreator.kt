package com.santimattius.android.skeleton.core.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceCreator(baseUrl: String) {

    private val gson = GsonBuilder().create()
    private val gsonConverterFactory = GsonConverterFactory.create(gson)

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    val retrofit =
        Retrofit.Builder().baseUrl(baseUrl).client(client).addConverterFactory(gsonConverterFactory)
            .build()

    inline fun <reified S> create() = this.retrofit.create<S>()

}