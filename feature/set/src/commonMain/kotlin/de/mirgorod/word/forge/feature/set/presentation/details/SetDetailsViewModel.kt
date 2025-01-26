package de.mirgorod.word.forge.feature.set.presentation.details

import androidx.lifecycle.viewModelScope
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import de.mirgorod.word.forge.core.common.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class SetDetailsViewModel(
    private val setId: Long,
    private val wordsRepository: WordsRepository,
): BaseViewModel() {

    private val _state: MutableStateFlow<SetDetailsUiState> = MutableStateFlow(SetDetailsUiState())
    val state: StateFlow<SetDetailsUiState> = _state.asStateFlow()

    init {
        fetchWordSet(setId = setId)
    }

    fun handleEvent(event: SetDetailsEvent) {

    }

    private fun fetchWordSet(setId: Long) {
        viewModelScope.launch {
            wordsRepository.getWordsBySetId(setId = setId).collectLatest { wordList ->
                _state.value = _state.value.copy(wordsList = wordList)
            }
        }
    }
}