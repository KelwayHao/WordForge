package de.mirgorod.word.forge.feature.flashcard.presentation

import androidx.compose.runtime.Immutable
import de.mirgorod.word.forge.core.common.domain.model.Word

@Immutable
data class FlashcardUiState(
    val wordsList: List<Word> = emptyList(),
    val currentWordIndex: Int = 0,
) {
    val currentWord: Word?
        get() = wordsList.getOrNull(currentWordIndex)
}