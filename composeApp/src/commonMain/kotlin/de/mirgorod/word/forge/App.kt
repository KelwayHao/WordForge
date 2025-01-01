package de.mirgorod.word.forge

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.mirgorod.word.forge.feature.bottomnavbar.BottomNavigationBar
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Home
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Settings
import de.mirgorod.word.forge.feature.home.presentation.HomeContent
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module

@Composable
@Preview
fun App(
    platformModule: Module = Module()
) {
    KoinApplication(
        application = { modules(koinModules(platformModule = platformModule)) }
    ) {
        val navController = rememberNavController()

        MaterialTheme {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController = navController) }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Home,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable<Home> { HomeContent() }
                    composable<Settings> { /*TODO*/ }
                }
            }
        }
    }
}