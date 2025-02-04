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
internal data class DarkColors(
    override val text: KitTextColor = DarkTextColor(),
    override val textTransparent: KitTextColorTransparent = DarkTextColorTransparent(),
    override val background: KitBackgroundColor = DarkBackgroundColor(),
    override val border: KitBorderColor = DarkBorderColors(),
    override val special: KitSpecialBackground = DarkSpecialBackground(),
    override val graphics: KitGraphicsColor = DarkGraphicsColor(),
) : KitColor

@Suppress("MagicNumber")
@Immutable
internal data class DarkTextColor(
    override val primary: Color = Color(0xFFFFFFFF),
    override val secondary: Color = Color(0xFF8D8D93),
    override val tertiary: Color = Color(0xFFC5C5C7),
    override val disabled: Color = Color(0xFF2A2A2C),
    override val primaryInverted: Color = Color(0xFF000000),
    override val secondaryInverted: Color = Color(0xFF8A8A8E),
    override val tertiaryInverted: Color = Color(0xFFC5C5C7),
    override val accent: Color = Color(0xFFFF4810),
    override val link: Color = Color(0xFF0072EF),
    override val positive: Color = Color(0xFF1DBE67),
    override val attention: Color = Color(0xFFFFA451),
    override val negative: Color = Color(0xFFE25A5A),
    override val whiteConstant: Color = Color(0xFFFFFFFF),
) : KitTextColor

@Suppress("MagicNumber")
@Immutable
internal data class DarkTextColorTransparent(
    override val secondary: Color = Color(0x99EBEBF5),
    override val tertiary: Color = Color(0x4DEBEBF5),
    override val disabled: Color = Color(0x2EEBEBF5),
    override val secondaryInverted: Color = Color(0x993C3C43),
    override val tertiaryInverted: Color = Color(0x4D3C3C43),
) : KitTextColorTransparent

@Suppress("MagicNumber")
@Immutable
internal data class DarkBackgroundColor(
    override val primary: Color = Color(0xFF121212),
    override val secondary: Color = Color(0xFF202022),
    override val tertiary: Color = Color(0xFF2C2C2E),
    override val neutral: Color = Color(0xFF3A3A3C),
    override val primaryInverted: Color = Color(0xFFFFFFFF),
    override val secondaryInverted: Color = Color(0xFFF3F4F5),
    override val tertiaryInverted: Color = Color(0xFFE9E9EB),
    override val accent: Color = Color(0xFFFF4810),
    override val info: Color = Color(0xFF273349),
    override val positive: Color = Color(0xFF21362A),
    override val attention: Color = Color(0xFF472F19),
    override val negative: Color = Color(0xFF482224),
    override val surfaceOnboarding: Color = Color.Gray,
    override val rippleColor: Color = Color(0x3CF3F4F5),
) : KitBackgroundColor

@Suppress("MagicNumber")
@Immutable
internal data class DarkBorderColors(
    override val primary: Color = Color(0xFF2B2B2E),
    override val secondary: Color = Color(0xFF262629),
    override val tertiary: Color = Color(0xFF1C1C1E),
    override val key: Color = Color(0xFFFFFFFF),
    override val secondaryInverted: Color = Color(0xFFE9E9EB),
    override val tertiaryInverted: Color = Color(0xFFF3F4F5),
    override val keyInverted: Color = Color(0xFF121212),
    override val accent: Color = Color(0xFFFF4810),
) : KitBorderColor

@Suppress("MagicNumber")
@Immutable
internal data class DarkSpecialBackground(
    override val nulled: Color = Color(0xFFFFFFFF),
    override val primaryGrouped: Color = Color(0xFF202022),
    override val secondaryGrouped: Color = Color(0xFF2C2C2E),
    override val tertiaryGrouped: Color = Color(0xFF3A3A3C),
    override val overlayFallback: Color = Color(0xFF070707),
) : KitSpecialBackground

@Suppress("MagicNumber")
@Immutable
internal data class DarkGraphicsColor(
    override val primary: Color = Color(0xFFFFFFFF),
    override val secondary: Color = Color(0xFF8D8D93),
    override val tertiary: Color = Color(0xFF464649),
    override val neutral: Color = Color(0xFF2A2A2C),
    override val accent: Color = Color(0xFFFF4810),
    override val primaryInverted: Color = Color(0xFF121212),
    override val positive: Color = Color(0xFF1DBE67),
    override val attention: Color = Color(0xFFFFA451),
    override val negative: Color = Color(0xFFE25A5A),
    override val link: Color = Color(0xFF0072EF),
    override val linkDisabled: Color = Color(0x332576E5),
    override val blueChill: Color = Color(0xFF0F9C8C),
    override val jaffa: Color = Color(0xFFF07134),
    override val whiteConstant: Color = Color(0xFFFFFFFF),
) : KitGraphicsColor
