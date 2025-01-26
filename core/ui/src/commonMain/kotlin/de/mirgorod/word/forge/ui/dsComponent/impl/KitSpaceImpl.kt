package de.mirgorod.word.forge.ui.dsComponent.impl

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.ui.dsComponent.KitRadius
import de.mirgorod.word.forge.ui.dsComponent.KitSize
import de.mirgorod.word.forge.ui.dsComponent.KitSpace

internal class KitRadiusImpl(
    override val xss: Dp = 4.dp,
    override val xs: Dp = 8.dp,
    override val s: Dp = 10.dp,
    override val m: Dp = 12.dp,
    override val l: Dp = 16.dp,
    override val xl: Dp = 24.dp,
    override val xxl: Dp = 32.dp,
    override val xxxl: Dp = 100.dp,
) : KitRadius

internal class KitSpaceImpl(
    override val xss: Dp = 4.dp,
    override val xs: Dp = 8.dp,
    override val s: Dp = 16.dp,
    override val m: Dp = 24.dp,
    override val l: Dp = 48.dp,
    override val xl: Dp = 64.dp,
    override val xxl: Dp = 128.dp,
) : KitSpace

internal class KitSizeImpl(
    override val iconS: Dp = 16.dp,
    override val iconM: Dp = 24.dp,
    override val iconL: Dp = 48.dp,
    override val iconXl: Dp = 64.dp,
    override val iconXXL: Dp = 128.dp,
    override val iconXXXL: Dp = 200.dp,
    override val iconXXXXL: Dp = 240.dp,
    override val toolbar: Dp = 56.dp,
    override val strokeXs: Dp = 1.dp,
    override val strokeS: Dp = 1.5.dp,
    override val strokeM: Dp = 2.dp,
    override val buttonS: Dp = 32.dp,
    override val buttonM: Dp = 40.dp,
    override val buttonL: Dp = 56.dp,
) : KitSize
