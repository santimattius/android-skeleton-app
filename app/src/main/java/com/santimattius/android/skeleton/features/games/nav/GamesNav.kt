package com.santimattius.android.skeleton.features.games.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.NavGraphBuilder
import com.santimattius.android.skeleton.features.games.ui.GamesRoute
import com.santimattius.android.skeleton.navigation.Features
import com.santimattius.android.skeleton.navigation.NavCommand
import com.santimattius.android.skeleton.navigation.TWEEN_ANIM_DURATION
import com.santimattius.android.skeleton.navigation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.gamesNav(width: Int) {
    composable(
        navCommand = NavCommand.ContentType(Features.GAMES),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { width }
            ) + fadeIn(animationSpec = tween(TWEEN_ANIM_DURATION))
        }
    ) {
        val current = LocalUriHandler.current
        GamesRoute {
            current.openUri("app://game/${it.id}")
        }
    }
}