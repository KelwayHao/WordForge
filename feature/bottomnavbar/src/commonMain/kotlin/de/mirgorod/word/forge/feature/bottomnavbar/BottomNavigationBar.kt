package de.mirgorod.word.forge.feature.bottomnavbar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import de.mirgorod.word.forge.feature.bottomnavbar.nav.item.BottomNavItem
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Home
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Settings
import org.jetbrains.compose.resources.stringResource
import wordforge.feature.bottomnavbar.generated.resources.Res
import wordforge.feature.bottomnavbar.generated.resources.bottom_nav_item_home
import wordforge.feature.bottomnavbar.generated.resources.bottom_nav_item_settings

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val menuItems = listOf(
            BottomNavItem(Res.string.bottom_nav_item_home, Home, Icons.Default.Menu),
            BottomNavItem(Res.string.bottom_nav_item_settings, Settings, Icons.Default.Settings, isEnable = false)
        )
        menuItems.forEach { item ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any {
                    it.hasRoute(
                        route = item::class.toString(),
                        arguments = null,
                    )
                } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(resource = item.name)
                    )
                },
                label = { Text(text = stringResource(resource = item.name)) },
                enabled = item.isEnable,
            )
        }
    }
}