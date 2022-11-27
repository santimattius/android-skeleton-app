package com.santimattius.android.skeleton.features.games.data.datasource

import com.santimattius.android.skeleton.features.games.data.model.GameDto

interface NetworkDataSource {
    suspend fun getGames(): Result<List<GameDto>>
}