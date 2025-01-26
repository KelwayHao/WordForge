package de.mirgorod.word.forge.ui.dsComponent

import androidx.compose.ui.graphics.Color

interface KitColor {
    val text: KitTextColor
    val textTransparent: KitTextColorTransparent
    val background: KitBackgroundColor
    val border: KitBorderColor
    val special: KitSpecialBackground
    val graphics: KitGraphicsColor
}

interface KitTextColor {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val disabled: Color
    val primaryInverted: Color
    val secondaryInverted: Color
    val tertiaryInverted: Color
    val accent: Color
    val link: Color
    val positive: Color
    val attention: Color
    val negative: Color
    val whiteConstant: Color
}

interface KitTextColorTransparent {
    val secondary: Color
    val tertiary: Color
    val disabled: Color
    val secondaryInverted: Color
    val tertiaryInverted: Color
}

interface KitBackgroundColor {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val neutral: Color
    val primaryInverted: Color
    val secondaryInverted: Color
    val tertiaryInverted: Color
    val accent: Color
    val info: Color
    val positive: Color
    val attention: Color
    val negative: Color
    val surfaceOnboarding: Color
    val rippleColor: Color
}

interface KitBorderColor {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val key: Color
    val secondaryInverted: Color
    val tertiaryInverted: Color
    val keyInverted: Color
    val accent: Color
}

interface KitSpecialBackground {
    val nulled: Color
    val primaryGrouped: Color
    val secondaryGrouped: Color
    val tertiaryGrouped: Color
    val overlayFallback: Color
}

interface KitGraphicsColor {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val neutral: Color
    val accent: Color
    val primaryInverted: Color
    val positive: Color
    val attention: Color
    val negative: Color
    val link: Color
    val linkDisabled: Color
    val blueChill: Color
    val jaffa: Color
    val whiteConstant: Color
}