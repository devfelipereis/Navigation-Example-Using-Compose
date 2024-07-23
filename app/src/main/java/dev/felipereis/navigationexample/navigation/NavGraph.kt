package dev.felipereis.navigationexample.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.felipereis.navigationexample.presentation.screens.home.HomeScreen
import dev.felipereis.navigationexample.presentation.screens.profile.ProfileScreen
import kotlin.random.Random

@SuppressLint("RestrictedApi")
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onNavigateToProfile = {
                    navController.navigate(Screen.Profile(userId = Random.nextInt(0,10)))
                }
            )
        }

        composable<Screen.Profile> { backStackEntry ->
            val profile = backStackEntry.toRoute<Screen.Profile>()

            ProfileScreen(
                userId = profile.userId,
                onReturnToHomeScreen = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}

val NavHostController.canGoBack: Boolean
        get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED