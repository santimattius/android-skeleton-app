package com.santimattius.android.skeleton.features.games.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.android.skeleton.features.games.data.repositories.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repository: GameRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<GamesUiState>(Loading)
    val state = _state.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.update { Failed }
    }

    init {
        load()
    }

    private fun load() {
        _state.update { Loading }
        viewModelScope.launch(exceptionHandler) {
            val result = repository.getAll()
            val games = result.getOrNull()
            _state.update {
                if (games == null) {
                    Failed
                } else {
                    Loaded(games)
                }
            }
        }
    }
}