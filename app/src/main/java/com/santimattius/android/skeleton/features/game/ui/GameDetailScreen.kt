package com.santimattius.android.skeleton.features.game.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.santimattius.android.skeleton.R
import com.santimattius.android.skeleton.core.ui.Center
import com.santimattius.android.skeleton.features.shared.domain.Game

private const val ASPECT_WIDTH = 16
private const val ASPECT_HEIGHT = 8

@Composable
fun GameDetailRoute(
    viewModel: GameDetailViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    GameDetailPage(state = state)
}

@Composable
private fun GameDetailPage(modifier: Modifier = Modifier, state: GameDetailUiState) {
    when (state) {
        Loading -> Center(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }

        Failed -> Center(modifier = modifier.fillMaxSize()) {
            Text(text = stringResource(id = R.string.message_error))
        }

        is Loaded -> GameDetail(state.data)
    }

}

@Composable
private fun GameDetail(data: Game) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SubcomposeAsyncImage(
            model = data.thumbnail,
            contentDescription = data.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .aspectRatio(ratio = (ASPECT_WIDTH / ASPECT_HEIGHT).toFloat())
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium)))
        Text(
            text = data.title,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(
                horizontal = dimensionResource(R.dimen.medium),
                vertical = dimensionResource(R.dimen.none)
            )
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.small)))
        Text(
            text = data.description,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(R.dimen.medium),
                    vertical = dimensionResource(R.dimen.none)
                )
        )
        Spacer(modifier = Modifier.height(height = dimensionResource(id = R.dimen.medium)))
    }
}