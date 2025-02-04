package de.mirgorod.word.forge.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TextStyle.setNonScaledSp(): TextStyle {
    val textStyle = this
    val density = LocalDensity.current
    return textStyle.copy(
        fontSize = with(density) { textStyle.fontSize.value.dp.toSp() },
        lineHeight = with(density) { textStyle.lineHeight.value.dp.toSp() },
    )
}
