package de.mirgorod.word.forge

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.mirgorod.word.forge.feature.add.set.presentation.add.AddSetContent
import de.mirgorod.word.forge.feature.bottomnavbar.BottomNavigationBar
import de.mirgorod.word.forge.feature.flashcard.presentation.FlashcardContent
import de.mirgorod.word.forge.feature.home.presentation.HomeContent
import de.mirgorod.word.forge.feature.set.presentation.details.SetDetailsContent
import de.mirgorod.word.forge.navigation.di.navigationModule
import de.mirgorod.word.forge.navigation.domain.model.AddSet
import de.mirgorod.word.forge.navigation.domain.model.Flashcard
import de.mirgorod.word.forge.navigation.domain.model.Home
import de.mirgorod.word.forge.navigation.domain.model.SetDetails
import de.mirgorod.word.forge.navigation.domain.model.Settings
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
    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                koinModules(
                    platformModule = platformModule,
                    navigationModule = navigationModule(navController = navController)
                )
            )
        }
    ) {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry?.destination?.route

        val shouldShowBottomBar = currentDestination in listOf(
            Home::class.qualifiedName, AddSet::class.qualifiedName, Settings::class.qualifiedName
        )

        KitTheme {
            Scaffold(
                bottomBar = {
                    if (shouldShowBottomBar) {
                        BottomNavigationBar(navController = navController)
                    }
                }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Home,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable<Home> {
                        HomeContent()
                    }
                    composable<AddSet> {
                        AddSetContent()
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
                    composable<Flashcard> { backStackEntry ->
                        val flashcard = backStackEntry.toRoute<Flashcard>()
                        FlashcardContent(setId = flashcard.setId)
                    }
                }
            }
        }
    }
}
