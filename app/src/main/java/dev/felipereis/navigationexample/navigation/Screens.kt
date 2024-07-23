package dev.felipereis.navigationexample.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()
    @Serializable
    data object Favorites : Screen()
    @Serializable
    data class Profile(
        val userId: Int
    ): Screen()
}