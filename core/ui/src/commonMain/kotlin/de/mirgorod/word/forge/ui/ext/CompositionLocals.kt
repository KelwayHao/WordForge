package de.mirgorod.word.forge.ui.ext

import androidx.compose.runtime.staticCompositionLocalOf

val LocalUserInterfaceEnabledListener = staticCompositionLocalOf<Boolean> {
    error("No default LocalUserInterfaceEnabledListener not provided")
}
