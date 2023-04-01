package com.santimattius.android.skeleton.features.shared.data.repositories

import com.santimattius.android.skeleton.features.shared.data.datasource.NetworkDataSource
import com.santimattius.android.skeleton.features.shared.data.model.GameDto
import com.santimattius.android.skeleton.features.shared.domain.Game

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

    suspend fun get(id: Long): Result<Game> = networkDataSource.getGame(id).fold(
        onSuccess = {
            Result.success(it.dtoToDomain())
        },
        onFailure = {
            Result.failure(GetGameFailed("Call failure: reason ${it.message}"))
        }
    )

    private fun List<GameDto>.dtoToDomain(): List<Game> {
        return map { it.dtoToDomain() }
    }

    private fun GameDto.dtoToDomain() = Game(
        id = this.id,
        title = this.title,
        thumbnail = this.thumbnail,
        description = this.shortDescription,
        genre = this.genre,
        platform = this.platform,
        publisher = this.publisher,
        developer = this.developer,
        releaseDate = this.releaseDate,
    )
}