package de.mirgorod.word.forge.ui.dsComponent.impl.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.mirgorod.word.forge.ui.dsComponent.KitTitleTypography

@Suppress("MagicNumber")
@Immutable
internal object HeadlineTypography : KitTitleTypography {
    override val xLarge: TextStyle = TextStyle(
        fontSize = 34.0.sp,
        lineHeight = 41.0.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.37.sp,
    )
    override val large: TextStyle = TextStyle(
        fontSize = 30.0.sp,
        lineHeight = 36.0.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.36.sp,
    )
    override val medium: TextStyle = TextStyle(
        fontSize = 27.0.sp,
        lineHeight = 32.0.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.35.sp,
    )
    override val small: TextStyle = TextStyle(
        fontSize = 22.0.sp,
        lineHeight = 28.0.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.35.sp,
    )
    override val xSmall: TextStyle = TextStyle(
        fontSize = 17.0.sp,
        lineHeight = 24.0.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.41).sp,
    )
}
