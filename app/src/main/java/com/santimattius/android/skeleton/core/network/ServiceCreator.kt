package com.santimattius.android.skeleton.core.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceCreator(baseUrl: String) {

    private val gson = GsonBuilder().create()
    private val gsonConverterFactory = GsonConverterFactory.create(gson)

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .build()

    inline fun <reified S> create() = this.retrofit.create<S>()

}