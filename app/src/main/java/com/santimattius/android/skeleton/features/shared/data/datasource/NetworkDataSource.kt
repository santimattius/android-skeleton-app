package com.santimattius.android.skeleton.features.shared.data.datasource

import com.santimattius.android.skeleton.features.shared.data.model.GameDto

interface NetworkDataSource {
    suspend fun getGames(): Result<List<GameDto>>

    suspend fun getGame(id: Long): Result<GameDto>
}