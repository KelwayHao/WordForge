package de.mirgorod.word.forge.ui.dsComponent

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.ui.dsComponent.impl.DarkColors
import de.mirgorod.word.forge.ui.dsComponent.impl.KitRadiusImpl
import de.mirgorod.word.forge.ui.dsComponent.impl.KitSizeImpl
import de.mirgorod.word.forge.ui.dsComponent.impl.KitSpaceImpl
import de.mirgorod.word.forge.ui.dsComponent.impl.LightColors
import de.mirgorod.word.forge.ui.dsComponent.model.RoundedCornerThemeModel
import de.mirgorod.word.forge.ui.ext.LocalUserInterfaceEnabledListener
import de.mirgorod.word.forge.ui.ext.setNonScaledSp

@Composable
fun KitTheme(
    roundedCornerTheme: RoundedCornerThemeModel = RoundedCornerThemeModel.UNSPECIFIED,
    isLightMode: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colors = provideKitTextColor(isLight = isLightMode)
    val typography = provideTypography()
    val shape = provideShape()

    MaterialTheme(
        colors = colors.mapToMaterialColors(),
        typography = typography.mapToTypography(),
        shapes = shape.mapToShape(),
        content = {
            CompositionLocalProvider(
                LocalKitTypography provides typography,
                LocalKitColor provides colors,
                LocalKitShape provides shape,
                LocalContentColor provides colors.graphics.primary,
                LocalHapticFeedback provides LocalHapticFeedback.current,
                LocalUserInterfaceEnabledListener provides true,
            ) {
                Surface(
                    content = content,
                    shape = when (roundedCornerTheme) {
                        RoundedCornerThemeModel.TOP -> RoundedTopCornerShape
                        RoundedCornerThemeModel.ALL -> RoundedAllCornerShape
                        else -> RectangleShape
                    },
                )
            }
        },
    )
}

val LocalKitTypography = staticCompositionLocalOf<KitTypography> {
    error("No default typography provided")
}

val LocalKitColor = staticCompositionLocalOf<KitColor> {
    error("No default color provided")
}

val LocalKitShape = staticCompositionLocalOf<KitShape> {
    error("No default shape provided")
}

@Composable
private fun provideKitTextColor(isLight: Boolean): KitColor =
    if (isLight) LightColors() else DarkColors()

@Composable
private fun provideTypography(): KitTypography {
    val typography = KitTypography()
    return typography.copy(
        headline = object : KitTitleTypography {
            override val xLarge: TextStyle = typography.headline.xLarge.setNonScaledSp()
            override val large: TextStyle = typography.headline.large.setNonScaledSp()
            override val medium: TextStyle = typography.headline.medium.setNonScaledSp()
            override val small: TextStyle = typography.headline.small.setNonScaledSp()
            override val xSmall: TextStyle = typography.headline.xSmall.setNonScaledSp()
        },
        promo = object : KitTitleTypography {
            override val xLarge: TextStyle = typography.headline.xLarge.setNonScaledSp()
            override val large: TextStyle = typography.headline.large.setNonScaledSp()
            override val medium: TextStyle = typography.headline.medium.setNonScaledSp()
            override val small: TextStyle = typography.headline.small.setNonScaledSp()
            override val xSmall: TextStyle = typography.headline.xSmall.setNonScaledSp()
        },
        paragraph = object : KitContentTypography {
            override val primaryLarge: TextStyle =
                typography.paragraph.primaryLarge.setNonScaledSp()
            override val primaryMedium: TextStyle =
                typography.paragraph.primaryMedium.setNonScaledSp()
            override val primarySmall: TextStyle =
                typography.paragraph.primarySmall.setNonScaledSp()
            override val secondaryLarge: TextStyle =
                typography.paragraph.secondaryLarge.setNonScaledSp()
            override val secondaryMedium: TextStyle =
                typography.paragraph.secondaryMedium.setNonScaledSp()
            override val secondarySmall: TextStyle =
                typography.paragraph.secondarySmall.setNonScaledSp()
            override val component: TextStyle =
                typography.paragraph.component.setNonScaledSp()
            override val tagline: TextStyle = typography.paragraph.tagline.setNonScaledSp()
            override val caps: TextStyle = typography.paragraph.caps.setNonScaledSp()
        },
        action = object : KitContentTypography {
            override val primaryLarge: TextStyle =
                typography.action.primaryLarge.setNonScaledSp()
            override val primaryMedium: TextStyle =
                typography.action.primaryMedium.setNonScaledSp()
            override val primarySmall: TextStyle =
                typography.action.primarySmall.setNonScaledSp()
            override val secondaryLarge: TextStyle =
                typography.action.secondaryLarge.setNonScaledSp()
            override val secondaryMedium: TextStyle =
                typography.action.secondaryMedium.setNonScaledSp()
            override val secondarySmall: TextStyle =
                typography.action.secondarySmall.setNonScaledSp()
            override val component: TextStyle =
                typography.action.component.setNonScaledSp()
            override val tagline: TextStyle = typography.action.tagline.setNonScaledSp()
            override val caps: TextStyle = typography.action.caps.setNonScaledSp()
        },
        accent = object : KitContentTypography {
            override val primaryLarge: TextStyle =
                typography.accent.primaryLarge.setNonScaledSp()
            override val primaryMedium: TextStyle =
                typography.accent.primaryMedium.setNonScaledSp()
            override val primarySmall: TextStyle =
                typography.accent.primarySmall.setNonScaledSp()
            override val secondaryLarge: TextStyle =
                typography.accent.secondaryLarge.setNonScaledSp()
            override val secondaryMedium: TextStyle =
                typography.accent.secondaryMedium.setNonScaledSp()
            override val secondarySmall: TextStyle =
                typography.accent.secondarySmall.setNonScaledSp()
            override val component: TextStyle =
                typography.accent.component.setNonScaledSp()
            override val tagline: TextStyle = typography.accent.tagline.setNonScaledSp()
            override val caps: TextStyle = typography.accent.caps.setNonScaledSp()
        },
    )
}

@Composable
private fun provideShape(): KitShape =
    KitShape(space = KitSpaceImpl(), size = KitSizeImpl(), radius = KitRadiusImpl())

@Composable
private fun KitColor.mapToMaterialColors() = MaterialTheme.colors.copy(
    primary = this.graphics.accent,
    primaryVariant = this.graphics.accent,
    secondary = this.graphics.accent,
    secondaryVariant = this.graphics.accent,
    background = this.background.primary,
    surface = this.background.primary,
    error = this.graphics.negative,
    onPrimary = this.text.primary,
    onSecondary = this.text.primary,
    onBackground = this.text.secondary,
    onSurface = this.text.primary,
    onError = this.text.primary,
    isLight = true,
)

@Composable
private fun KitTypography.mapToTypography() = Typography(
    h1 = this.headline.xLarge,
    h2 = this.headline.large,
    h3 = this.headline.medium,
    h4 = this.headline.small,
    h5 = this.headline.xSmall,
    h6 = this.headline.xSmall,
    subtitle1 = this.accent.primaryLarge,
    subtitle2 = this.accent.primaryMedium,
    body1 = this.paragraph.primaryLarge,
    body2 = this.paragraph.primaryMedium,
    button = this.action.primarySmall,
    caption = this.paragraph.secondaryLarge,
    overline = this.paragraph.secondaryMedium,
)

@Composable
private fun KitShape.mapToShape(): Shapes = Shapes(
    small = RoundedCornerShape(this.space.s),
    medium = RoundedCornerShape(this.space.m),
    large = RoundedCornerShape(this.space.l),
)

private val RoundedTopCornerShape = RoundedCornerShape(
    topStart = 12.dp,
    topEnd = 12.dp,
)
private val RoundedAllCornerShape = RoundedCornerShape(
    topStart = 16.dp,
    topEnd = 16.dp,
    bottomStart = 16.dp,
    bottomEnd = 16.dp,
)