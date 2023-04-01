package com.santimattius.android.skeleton.features.shared.data.datasource

import com.santimattius.android.skeleton.core.network.FreeToGameService
import com.santimattius.android.skeleton.features.shared.data.model.GameDto

class FreeToGameDataSource(
    private val service: FreeToGameService,
) : NetworkDataSource {

    override suspend fun getGames() =
        runCatching { service.getAll(platform = "pc", category = "shooter") }

    override suspend fun getGame(id: Long): Result<GameDto> = runCatching { service.get(id = id) }

}