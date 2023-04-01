package com.santimattius.android.skeleton.features.game.ui

import com.santimattius.android.skeleton.features.shared.domain.Game

sealed interface GameDetailUiState

object Loading : GameDetailUiState

data class Loaded(val data: Game) : GameDetailUiState

object Failed : GameDetailUiState