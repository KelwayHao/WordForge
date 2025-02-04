package de.mirgorod.word.forge.feature.add.set.presentation.add

import androidx.compose.runtime.Immutable
import de.mirgorod.word.forge.core.common.domain.model.Word

@Immutable
internal data class AddSetUiState(
    val nameSet: String = "",
    val wordsList: List<Word> = listOf(Word(term = "", definition = ""))
)
