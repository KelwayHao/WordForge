package de.mirgorod.word.forge.ui.dsComponent

import androidx.compose.ui.unit.Dp

data class KitShape(
    val space: KitSpace,
    val size: KitSize,
    val radius: KitRadius,
)

interface KitRadius {
    val xss: Dp
    val xs: Dp
    val s: Dp
    val m: Dp
    val l: Dp
    val xl: Dp
    val xxl: Dp
    val xxxl: Dp
}

interface KitSpace {
    val xss: Dp
    val xs: Dp
    val s: Dp
    val m: Dp
    val l: Dp
    val xl: Dp
    val xxl: Dp
}

interface KitSize {
    val iconS: Dp
    val iconM: Dp
    val iconL: Dp
    val iconXl: Dp
    val iconXXL: Dp
    val iconXXXL: Dp
    val iconXXXXL: Dp
    val toolbar: Dp
    val strokeXs: Dp
    val strokeS: Dp
    val strokeM: Dp
    val buttonS: Dp
    val buttonM: Dp
    val buttonL: Dp
}
