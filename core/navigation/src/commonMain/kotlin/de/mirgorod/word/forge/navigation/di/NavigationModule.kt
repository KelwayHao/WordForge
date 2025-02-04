package de.mirgorod.word.forge.navigation.di

import androidx.navigation.NavController
import de.mirgorod.word.forge.navigation.data.NavigationImpl
import de.mirgorod.word.forge.navigation.domain.router.NavigationRouter
import org.koin.dsl.module

fun navigationModule(navController: NavController) = module {
    single<NavigationRouter> { NavigationImpl(navController = navController) }
}
