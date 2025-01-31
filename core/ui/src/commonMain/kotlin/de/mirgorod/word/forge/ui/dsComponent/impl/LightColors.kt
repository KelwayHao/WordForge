package de.mirgorod.word.forge.ui.dsComponent.impl

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import de.mirgorod.word.forge.ui.dsComponent.KitBackgroundColor
import de.mirgorod.word.forge.ui.dsComponent.KitBorderColor
import de.mirgorod.word.forge.ui.dsComponent.KitColor
import de.mirgorod.word.forge.ui.dsComponent.KitGraphicsColor
import de.mirgorod.word.forge.ui.dsComponent.KitSpecialBackground
import de.mirgorod.word.forge.ui.dsComponent.KitTextColor
import de.mirgorod.word.forge.ui.dsComponent.KitTextColorTransparent

@Immutable
internal data class LightColors(
    override val text: KitTextColor = LightTextColor(),
    override val textTransparent: KitTextColorTransparent = LightTextColorTransparent(),
    override val background: KitBackgroundColor = LightBackgroundColor(),
    override val border: KitBorderColor = LightBorderColors(),
    override val special: KitSpecialBackground = LightSpecialBackground(),
    override val graphics: KitGraphicsColor = LightGraphicsColor(),
) : KitColor

@Suppress("MagicNumber")
@Immutable
internal data class LightTextColor(
    override val primary: Color = Color(0xFF1D1D1B),
    override val secondary: Color = Color(0xFF8A8A8E),
    override val tertiary: Color = Color(0xFF41916C),
    override val disabled: Color = Color(0xFFDCDCDD),
    override val primaryInverted: Color = Color(0xFFFFFFFF),
    override val secondaryInverted: Color = Color(0xFF8D8D93),
    override val tertiaryInverted: Color = Color(0xFF464649),
    override val accent: Color = Color(0xFF0E3221),
    override val link: Color = Color(0xFF0072EF),
    override val positive: Color = Color(0xFF0DA660),
    override val attention: Color = Color(0xFFFFA451),
    override val negative: Color = Color(0xFFE25A5A),
    override val whiteConstant: Color = Color(0xFFFFFFFF),
) : KitTextColor

@Suppress("MagicNumber")
@Immutable
internal data class LightTextColorTransparent(
    override val secondary: Color = Color(0x993C3C43),
    override val tertiary: Color = Color(0x4D3C3C43),
    override val disabled: Color = Color(0x2E3C3C43),
    override val secondaryInverted: Color = Color(0x99E9E9EB),
    override val tertiaryInverted: Color = Color(0x4DE9E9EB),
) : KitTextColorTransparent

@Suppress("MagicNumber")
@Immutable
internal data class LightBackgroundColor(
    override val primary: Color = Color(0xFFFFFFFF),
    override val secondary: Color = Color(0xFFA9DEC6),
    override val tertiary: Color = Color(0xFF41916C),
    override val neutral: Color = Color(0xFFDCDCDD),
    override val primaryInverted: Color = Color(0xFF121212),
    override val secondaryInverted: Color = Color(0xFF202022),
    override val tertiaryInverted: Color = Color(0xFF1C1C1E),
    override val accent: Color = Color(0xFF0E3221),
    override val info: Color = Color(0xFFE8F2FE),
    override val positive: Color = Color(0xFFDCFFD9),
    override val attention: Color = Color(0xFFFFE9D4),
    override val negative: Color = Color(0xFFFFF0F0),
    override val surfaceOnboarding: Color = Color.Black,
    override val rippleColor: Color = Color(0x3C3C432E),
) : KitBackgroundColor

@Suppress("MagicNumber")
@Immutable
internal data class LightBorderColors(
    override val primary: Color = Color(0xFFDCDCDD),
    override val secondary: Color = Color(0xFFE9E9EB),
    override val tertiary: Color = Color(0xFFF3F4F5),
    override val key: Color = Color(0xFF000000),
    override val secondaryInverted: Color = Color(0xFF262629),
    override val tertiaryInverted: Color = Color(0xFF1C1C1E),
    override val keyInverted: Color = Color(0xFFFFFFFF),
    override val accent: Color = Color(0xFF0E3221),
) : KitBorderColor

@Suppress("MagicNumber")
@Immutable
internal data class LightSpecialBackground(
    override val nulled: Color = Color(0xFFFFFFFF),
    override val primaryGrouped: Color = Color(0xFFF3F4F5),
    override val secondaryGrouped: Color = Color(0xFFFFFFFF),
    override val tertiaryGrouped: Color = Color(0xFFF3F4F5),
    override val overlayFallback: Color = Color(0xFF5C5C5C),
) : KitSpecialBackground

@Suppress("MagicNumber")
@Immutable
internal data class LightGraphicsColor(
    override val primary: Color = Color(0xFF1D1D1B),
    override val secondary: Color = Color(0xFF8A8A8E),
    override val tertiary: Color = Color(0xFFC5C5C7),
    override val neutral: Color = Color(0xFFDCDCDD),
    override val accent: Color = Color(0xFF0E3221),
    override val primaryInverted: Color = Color(0xFFFFFFFF),
    override val positive: Color = Color(0xFF0DA660),
    override val attention: Color = Color(0xFFFFA451),
    override val negative: Color = Color(0xFFE25A5A),
    override val link: Color = Color(0xFF0072EF),
    override val linkDisabled: Color = Color(0x332576E5),
    override val blueChill: Color = Color(0xFF0F9C8C),
    override val jaffa: Color = Color(0xFFF07134),
    override val whiteConstant: Color = Color(0xFFFFFFFF),
) : KitGraphicsColor