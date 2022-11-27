package com.santimattius.android.skeleton.features.games.ui

import com.santimattius.android.skeleton.features.games.domain.Game

sealed interface GamesUiState

object Loading : GamesUiState

data class Loaded(val data: List<Game>) : GamesUiState

object Failed : GamesUiState