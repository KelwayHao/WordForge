package de.mirgorod.word.forge.feature.flashcard.presentation

import androidx.lifecycle.viewModelScope
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import de.mirgorod.word.forge.core.common.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class FlashcardViewModel(
    private val setId: Long,
    private val wordsRepository: WordsRepository,
) : BaseViewModel() {

    private val _state: MutableStateFlow<FlashcardUiState> = MutableStateFlow(FlashcardUiState())
    val state: StateFlow<FlashcardUiState> = _state.asStateFlow()

    init {
        fetchWordSet(setId = setId)
    }

    fun handleEvent(event: FlashcardEvent) {
        when (event) {
            is FlashcardEvent.KnowEvent -> handleNextWord(isLearned = true)
            is FlashcardEvent.DoNotKnowEvent -> handleNextWord()
        }
    }

    private fun fetchWordSet(setId: Long) {
        viewModelScope.launch {
            wordsRepository.getWordsBySetId(setId = setId).first().let { wordList ->
                _state.update { it.copy(wordsList = wordList.filter { list -> list.isLearned.not() }) }
            }
        }
    }

    private fun handleNextWord(isLearned: Boolean = false) {
        viewModelScope.launch {
            _state.value.currentWord?.id?.let { wordId ->
                wordsRepository.markWordAsLearned(
                    wordId = wordId,
                    isLearned = isLearned
                )
            }
            if (isNextWordAvailable()) {
                _state.update { it.copy(currentWordIndex = it.currentWordIndex.inc()) }
            } else {
                // TODO Navigate to RESULT SCREEN
            }
        }
    }

    private fun isNextWordAvailable(): Boolean {
        return _state.value.currentWordIndex.inc() < _state.value.wordsList.size
    }
}
