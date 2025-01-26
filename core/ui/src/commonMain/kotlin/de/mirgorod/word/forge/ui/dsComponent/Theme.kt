package de.mirgorod.word.forge.ui.dsComponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.Dp

object Theme {

    val color: KitColor
        @Composable
        @ReadOnlyComposable
        get() = LocalKitColor.current

    val shape: KitShape
        @Composable
        @ReadOnlyComposable
        get() = LocalKitShape.current

    val typography: KitTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalKitTypography.current

    val screenEdgePadding: Dp
        @Composable
        @ReadOnlyComposable
        get() = shape.space.s
}