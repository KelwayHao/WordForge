package de.mirgorod.word.forge.feature.bottomnavbar.nav.item

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

data class BottomNavItem<T : Any>(val name: StringResource, val route: T, val icon: ImageVector)