package com.santimattius.android.skeleton.features.game.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.NavGraphBuilder
import com.santimattius.android.skeleton.features.game.ui.GameDetailRoute
import com.santimattius.android.skeleton.navigation.Features
import com.santimattius.android.skeleton.navigation.NavCommand
import com.santimattius.android.skeleton.navigation.TWEEN_ANIM_DURATION
import com.santimattius.android.skeleton.navigation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.gameDetailNav(width: Int) {
    composable(
        navCommand = NavCommand.ContentTypeDetail(Features.GAMES),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { width }
            ) + fadeIn(animationSpec = tween(TWEEN_ANIM_DURATION))
        }
    ) {
        GameDetailRoute()
    }
}