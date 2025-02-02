package de.mirgorod.word.forge.navigation.data

import androidx.navigation.NavController
import de.mirgorod.word.forge.navigation.domain.router.NavigationRouter
import de.mirgorod.word.forge.navigation.domain.router.RouteDestination

internal class NavigationImpl(
    private val navController: NavController,
) : NavigationRouter {

    override fun navigateTo(
        route: RouteDestination,
        clearBackStackDestination: RouteDestination?,
        singleTop: Boolean
    ) {
        navController.navigate(route = route) {
            if (clearBackStackDestination != null) {
                popUpTo(clearBackStackDestination) { inclusive = true }
            }
            launchSingleTop = singleTop
        }
    }

    override fun goBack() {
        navController.popBackStack()
    }

}