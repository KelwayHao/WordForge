package de.mirgorod.word.forge.feature.bottomnavbar.item

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

@Immutable
data class BottomNavItem<T : Any>(
    val name: StringResource,
    val route: T,
    val icon: ImageVector,
    val isEnable: Boolean = true
)
