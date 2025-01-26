package de.mirgorod.word.forge.ui.dsComponent.impl.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.mirgorod.word.forge.ui.dsComponent.KitContentTypography

@Suppress("MagicNumber")
@Immutable
internal object ParagraphTypography : KitContentTypography {
    override val primaryLarge: TextStyle = TextStyle(
        fontSize = 19.0.sp,
        lineHeight = 24.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = (-0.49).sp,
    )
    override val primaryMedium: TextStyle = TextStyle(
        fontSize = 17.0.sp,
        lineHeight = 24.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = (-0.41).sp,
    )
    override val primarySmall: TextStyle = TextStyle(
        fontSize = 15.0.sp,
        lineHeight = 20.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = (-0.24).sp,
    )
    override val secondaryLarge: TextStyle = TextStyle(
        fontSize = 13.0.sp,
        lineHeight = 18.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = (-0.08).sp,
    )
    override val secondaryMedium: TextStyle = TextStyle(
        fontSize = 12.0.sp,
        lineHeight = 16.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = 0.sp,
    )
    override val secondarySmall: TextStyle = TextStyle(
        fontSize = 11.0.sp,
        lineHeight = 14.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = 0.07.sp,
    )
    override val component: TextStyle = TextStyle(
        fontSize = 17.0.sp,
        lineHeight = 22.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = (-0.41).sp,
    )
    override val tagline: TextStyle = TextStyle(
        fontSize = 13.0.sp,
        lineHeight = 18.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = (-0.08).sp,
    )
    override val caps: TextStyle = TextStyle(
        fontSize = 11.0.sp,
        lineHeight = 16.0.sp,
        fontWeight = FontWeight(450),
        letterSpacing = 1.25.sp,
    )
}