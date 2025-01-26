package de.mirgorod.word.forge.feature.set.presentation.details

import androidx.compose.runtime.Immutable
import de.mirgorod.word.forge.core.common.domain.model.Word

@Immutable
internal data class SetDetailsUiState(
    val wordsList: List<Word> = emptyList(),
)