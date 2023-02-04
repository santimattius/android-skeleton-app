package com.santimattius.android.skeleton.features.game.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.santimattius.android.skeleton.R

private const val ASPECT_WIDTH = 16
private const val ASPECT_HEIGHT = 8

@Composable
fun GameDetailRoute(
    viewModel: GameDetailViewModel = hiltViewModel(),
) {
    GameDetailPage()
}

@Composable
private fun GameDetailPage() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SubcomposeAsyncImage(
            model = "https://www.freetogame.com/g/452/thumbnail.jpg",
            contentDescription = "game.title",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .aspectRatio(ratio = (ASPECT_WIDTH / ASPECT_HEIGHT).toFloat())
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium)))
        Text(
            text = "character.name",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(
                horizontal = dimensionResource(R.dimen.medium),
                vertical = dimensionResource(R.dimen.none)
            )
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.small)))
        Text(
            text = """
                            Call of Duty: Warzone is both a standalone free-to-play battle royale and modes accessible via Call of Duty: Modern Warfare. Warzone features two modes — the general 150-player battle royle, and “Plunder”. The latter mode is described as a “race to deposit the most Cash”. In both modes players can both earn and loot cash to be used when purchasing in-match equipment, field upgrades, and more. Both cash and XP are earned in a variety of ways, including completing contracts.\r\n\r\nAn interesting feature of the game is one that allows players who have been killed in a match to rejoin it by winning a 1v1 match against other felled players in the Gulag.\r\n\r\nOf course, being a battle royale, the game does offer a battle pass. The pass offers players new weapons, playable characters, Call of Duty points, blueprints, and more. Players can also earn plenty of new items by completing objectives offered with the pass.
                        """.trimIndent(),
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