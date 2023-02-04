package com.santimattius.android.skeleton.features.games.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.annotation.ExperimentalCoilApi
import coil.compose.SubcomposeAsyncImage
import com.santimattius.android.skeleton.R
import com.santimattius.android.skeleton.features.games.domain.Game


@ExperimentalCoilApi
@ExperimentalLifecycleComposeApi
@Composable
fun GamesRoute(
    modifier: Modifier = Modifier,
    gamesViewModel: GamesViewModel = hiltViewModel(),
    onGameClick: (Game) -> Unit = {},
) {
    val state by gamesViewModel.state.collectAsStateWithLifecycle()
    GamesScreen(modifier = modifier, state = state, onItemClick = onGameClick)
}

@ExperimentalCoilApi
@Composable
fun GamesScreen(modifier: Modifier, state: GamesUiState, onItemClick: (Game) -> Unit = {}) {
    when (state) {
        Loading -> Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        Failed -> Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = stringResource(id = R.string.message_error))
        }
        is Loaded -> GamesList(games = state.data, onClick = onItemClick)
    }
}

private const val ASPECT_WIDTH = 16
private const val ASPECT_HEIGHT = 8

@ExperimentalCoilApi
@Composable
private fun GamesList(
    games: List<Game>,
    onClick: (Game) -> Unit = {},
) {
    LazyColumn {
        items(items = games, key = { it.id }) { game ->
            GameItem(game = game, modifier = Modifier.clickable {
                onClick(game)
            })
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun GameItem(modifier: Modifier = Modifier, game: Game) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Card {
            SubcomposeAsyncImage(
                model = game.thumbnail,
                contentDescription = game.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .aspectRatio(ratio = (ASPECT_WIDTH / ASPECT_HEIGHT).toFloat())
            )
        }
    }
}