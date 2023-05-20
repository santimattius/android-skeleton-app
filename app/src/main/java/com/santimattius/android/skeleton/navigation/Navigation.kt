package com.santimattius.android.skeleton.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

const val TWEEN_ANIM_DURATION = 1000

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    navController: NavHostController = rememberAnimatedNavController(),
) {
    BoxWithConstraints {
        AnimatedNavHost(
            navController = navController,
            startDestination = Features.GAMES.route
        ) {

        }
    }
}