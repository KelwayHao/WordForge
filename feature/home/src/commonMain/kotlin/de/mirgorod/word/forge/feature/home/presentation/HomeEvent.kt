package de.mirgorod.word.forge.feature.home.presentation

import androidx.compose.runtime.Immutable

@Immutable
internal sealed class HomeEvent {
    data class DeleteSet(val id: Long?) : HomeEvent()
    data class ClickSet(val id: Long) : HomeEvent()
}
