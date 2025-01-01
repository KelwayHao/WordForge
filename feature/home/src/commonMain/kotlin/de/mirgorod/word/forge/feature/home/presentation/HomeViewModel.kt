package de.mirgorod.word.forge.feature.home.presentation

import androidx.lifecycle.viewModelScope
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import de.mirgorod.word.forge.core.common.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val wordsRepository: WordsRepository,
) : BaseViewModel() {

    private val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        startObservingWords()
    }

    private fun startObservingWords() {
        viewModelScope.launch {
            wordsRepository.getAllWords().collectLatest { words ->
                _state.value = _state.value.copy(words = words)
            }
        }
    }
}