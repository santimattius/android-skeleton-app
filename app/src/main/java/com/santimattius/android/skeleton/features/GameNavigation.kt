package com.santimattius.android.skeleton.features

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santimattius.android.skeleton.features.game.nav.gameDetailNav
import com.santimattius.android.skeleton.features.games.nav.gamesNav
import com.santimattius.android.skeleton.navigation.Features
import com.santimattius.android.skeleton.navigation.NavCommand

fun NavGraphBuilder.gameNav(navController: NavController, width: Int) {
    navigation(
        startDestination = NavCommand.ContentType(Features.GAMES).route,
        route = Features.GAMES.route
    ) {
        gamesNav(width)
        gameDetailNav(width = width)
    }
}