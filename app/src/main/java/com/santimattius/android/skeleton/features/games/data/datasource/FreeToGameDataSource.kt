package com.santimattius.android.skeleton.features.games.data.datasource

import com.santimattius.android.skeleton.core.network.FreeToGameService

class FreeToGameDataSource(
    private val service: FreeToGameService,
) : NetworkDataSource {

    override suspend fun getGames() =
        runCatching { service.getAll(platform = "pc", category = "shooter") }

}