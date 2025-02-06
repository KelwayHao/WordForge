package de.mirgorod.word.forge.feature.home.presentation

import androidx.compose.runtime.Immutable
import de.mirgorod.word.forge.core.common.domain.model.WordSet

@Immutable
internal data class HomeUiState(
    val wordSetList: List<WordSet> = listOf(),
)
