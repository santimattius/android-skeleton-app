package com.santimattius.android.skeleton.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

enum class NavItem(
    val navCommand: NavCommand,
) {
    GAMES(NavCommand.ContentType(Features.GAMES)),
}

sealed class NavCommand(
    internal val feature: Features,
    internal val subRoute: String = "home",
    private val navArgs: List<NavArg> = emptyList(),
) {
    class ContentType(feature: Features) : NavCommand(feature)

    class ContentTypeDetail(feature: Features) : NavCommand(
        feature,
        "detail",
        listOf(NavArg.ItemId)
    ) {
        fun createRoute(itemId: Long) = "${feature.route}/$subRoute/$itemId"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    ItemId("id", NavType.LongType)
}