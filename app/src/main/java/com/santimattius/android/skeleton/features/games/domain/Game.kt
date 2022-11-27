package com.santimattius.android.skeleton.features.games.domain

data class Game(
    val id: Long,
    val title: String,
    val thumbnail: String,
    val description: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val releaseDate: String,
)
