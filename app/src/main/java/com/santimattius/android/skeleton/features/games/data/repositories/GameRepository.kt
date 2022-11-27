package com.santimattius.android.skeleton.features.games.data.repositories

import com.santimattius.android.skeleton.features.games.data.datasource.NetworkDataSource
import com.santimattius.android.skeleton.features.games.data.model.GameDto
import com.santimattius.android.skeleton.features.games.domain.Game

class GameRepository(
    private val networkDataSource: NetworkDataSource,
) {

    suspend fun getAll(): Result<List<Game>> {
        return networkDataSource.getGames().fold(onSuccess = {
            Result.success(it.dtoToDomain())
        }, onFailure = {
            Result.failure(GetAllGameFailed("Call failure: reason ${it.message}"))
        })
    }

    private fun List<GameDto>.dtoToDomain(): List<Game> {
        return map {
            Game(
                id = it.id,
                title = it.title,
                thumbnail = it.thumbnail,
                description = it.shortDescription,
                genre = it.genre,
                platform = it.platform,
                publisher = it.publisher,
                developer = it.developer,
                releaseDate = it.releaseDate,
            )
        }
    }
}