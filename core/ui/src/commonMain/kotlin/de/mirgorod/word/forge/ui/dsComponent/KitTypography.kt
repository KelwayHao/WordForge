package de.mirgorod.word.forge.ui.dsComponent

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import de.mirgorod.word.forge.ui.dsComponent.impl.typography.AccentTypography
import de.mirgorod.word.forge.ui.dsComponent.impl.typography.ActionTypography
import de.mirgorod.word.forge.ui.dsComponent.impl.typography.HeadlineTypography
import de.mirgorod.word.forge.ui.dsComponent.impl.typography.ParagraphTypography
import de.mirgorod.word.forge.ui.dsComponent.impl.typography.PromoTypography

@Immutable
data class KitTypography(
    val headline: KitTitleTypography = HeadlineTypography,
    val promo: KitTitleTypography = PromoTypography,
    val paragraph: KitContentTypography = ParagraphTypography,
    val action: KitContentTypography = ActionTypography,
    val accent: KitContentTypography = AccentTypography,
)

@Immutable
interface KitTitleTypography {
    val xLarge: TextStyle
    val large: TextStyle
    val medium: TextStyle
    val small: TextStyle
    val xSmall: TextStyle
}

@Immutable
interface KitContentTypography {
    val primaryLarge: TextStyle
    val primaryMedium: TextStyle
    val primarySmall: TextStyle
    val secondaryLarge: TextStyle
    val secondaryMedium: TextStyle
    val secondarySmall: TextStyle
    val component: TextStyle
    val tagline: TextStyle
    val caps: TextStyle
}
