package de.mirgorod.word.forge

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.mirgorod.word.forge.feature.add.set.presentation.add.AddSetContent
import de.mirgorod.word.forge.feature.bottomnavbar.BottomNavigationBar
import de.mirgorod.word.forge.feature.bottomnavbar.menu.AddSet
import de.mirgorod.word.forge.feature.bottomnavbar.menu.SetDetails
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Home
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Settings
import de.mirgorod.word.forge.feature.home.presentation.HomeContent
import de.mirgorod.word.forge.feature.set.presentation.details.SetDetailsContent
import de.mirgorod.word.forge.ui.dsComponent.KitTheme
import de.mirgorod.word.forge.ui.result.KitResultScreen
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import wordforge.composeapp.generated.resources.Res
import wordforge.composeapp.generated.resources.ic_not_available
import wordforge.composeapp.generated.resources.result_screen_not_available_yet

@Composable
@Preview
fun App(
    platformModule: Module = Module()
) {
    KoinApplication(
        application = { modules(koinModules(platformModule = platformModule)) }
    ) {
        val navController = rememberNavController()

        KitTheme {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController = navController) }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Home,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable<Home> {
                        HomeContent(
                            onNavigateToSetDetails = { setId ->
                                navController.navigate(route = SetDetails(setId = setId))
                            }
                        )
                    }
                    composable<AddSet> {
                        AddSetContent(
                            onNavigateToHome = {
                                navController.navigate(route = Home) {
                                    popUpTo(
                                        AddSet
                                    ) { inclusive = true }
                                }
                            }
                        )
                    }
                    composable<Settings> {
                        KitResultScreen(
                            messageText = stringResource(
                                resource = Res.string.result_screen_not_available_yet
                            ),
                            drawableResource = Res.drawable.ic_not_available,
                        )
                    }
                    composable<SetDetails> { backStackEntry ->
                        val setContent = backStackEntry.toRoute<SetDetails>()
                        SetDetailsContent(setId = setContent.setId)
                    }
                }
            }
        }
    }
}