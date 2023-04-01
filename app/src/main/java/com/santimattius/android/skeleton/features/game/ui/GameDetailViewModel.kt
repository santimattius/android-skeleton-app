package com.santimattius.android.skeleton.features.game.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.android.skeleton.features.shared.data.repositories.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val repository: GameRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow<GameDetailUiState>(Loading)
    val state = _state.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.update { Failed }
    }

    init {
        val id = savedStateHandle.get<Long>("id")
        load(id)
    }

    private fun load(id: Long?) {
        if (id == null) {
            _state.update { Failed }
        } else {
            viewModelScope.launch(exceptionHandler) {
                val result = repository.get(id).fold(
                    onSuccess = {
                        Loaded(it)
                    },
                    onFailure = {
                        Failed
                    }
                )
                _state.update { result }
            }
        }
    }
}