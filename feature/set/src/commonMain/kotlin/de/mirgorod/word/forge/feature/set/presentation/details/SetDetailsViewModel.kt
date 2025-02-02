package de.mirgorod.word.forge.feature.set.presentation.details

import androidx.lifecycle.viewModelScope
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import de.mirgorod.word.forge.core.common.viewmodel.BaseViewModel
import de.mirgorod.word.forge.navigation.domain.model.Flashcard
import de.mirgorod.word.forge.navigation.domain.router.NavigationRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class SetDetailsViewModel(
    private val setId: Long,
    private val router: NavigationRouter,
    private val wordsRepository: WordsRepository,
) : BaseViewModel() {

    private val _state: MutableStateFlow<SetDetailsUiState> = MutableStateFlow(SetDetailsUiState())
    val state: StateFlow<SetDetailsUiState> = _state.asStateFlow()

    init {
        fetchWordSet(setId = setId)
    }

    fun handleEvent(event: SetDetailsEvent) = when (event) {
        is SetDetailsEvent.OnClickFlashcardButton -> onClickFlashcardButton()
    }

    private fun fetchWordSet(setId: Long) {
        viewModelScope.launch {
            wordsRepository.getWordsBySetId(setId = setId).collectLatest { wordList ->
                _state.value = _state.value.copy(wordsList = wordList)
            }
        }
    }

    private fun onClickFlashcardButton() {
        router.navigateTo(route = Flashcard(setId = setId))
    }
}