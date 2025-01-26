package de.mirgorod.word.forge.feature.bottomnavbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import de.mirgorod.word.forge.feature.bottomnavbar.item.BottomNavItem
import de.mirgorod.word.forge.feature.bottomnavbar.menu.AddSet
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Home
import de.mirgorod.word.forge.feature.bottomnavbar.nav.menu.Settings
import de.mirgorod.word.forge.ui.dsComponent.Theme
import org.jetbrains.compose.resources.stringResource
import wordforge.feature.bottomnavbar.generated.resources.Res
import wordforge.feature.bottomnavbar.generated.resources.bottom_nav_item_add_set
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
            BottomNavItem(Res.string.bottom_nav_item_home, Home, Icons.Default.Home),
            BottomNavItem(Res.string.bottom_nav_item_add_set, AddSet, Icons.Default.Add),
            BottomNavItem(Res.string.bottom_nav_item_settings, Settings, Icons.Default.Settings)
        )
        menuItems.forEach { item ->
            val selected = currentDestination?.route == item.route::class.qualifiedName
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = false }
                        restoreState = false
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.padding(all = 4.dp),
                        imageVector = item.icon,
                        contentDescription = stringResource(resource = item.name),
                    )
                },
                label = {
                    Text(
                        text = stringResource(resource = item.name),
                        style = Theme.typography.action.primarySmall
                    )
                },
                enabled = item.isEnable,
                selectedContentColor = Theme.color.background.tertiary,
                unselectedContentColor = Theme.color.background.neutral,
            )
        }
    }
}