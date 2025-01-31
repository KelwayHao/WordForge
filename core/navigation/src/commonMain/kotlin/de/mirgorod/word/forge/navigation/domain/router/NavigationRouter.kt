package de.mirgorod.word.forge.navigation.domain.router

interface NavigationRouter {
    fun navigateTo(
        route: RouteDestination,
        clearBackStackDestination: RouteDestination? = null,
        singleTop: Boolean = true
    )

    fun goBack()
}