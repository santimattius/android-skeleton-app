package com.santimattius.android.skeleton.core.network

import com.santimattius.android.skeleton.features.shared.data.model.GameDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FreeToGameService {

    @GET("games")
    suspend fun getAll(
        @Query("platform") platform: String,
        @Query("category") category: String,
    ): List<GameDto>

    @GET("game")
    suspend fun get(
        @Query("id") id: Long,
    ): GameDto
}