package de.mirgorod.word.forge.feature.add.set.presentation.add

import androidx.lifecycle.viewModelScope
import de.mirgorod.word.forge.core.common.database.domain.repository.WordSetRepository
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import de.mirgorod.word.forge.core.common.domain.model.Word
import de.mirgorod.word.forge.core.common.domain.model.WordSet
import de.mirgorod.word.forge.core.common.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class AddSetViewModel(
    private val wordSetRepository: WordSetRepository,
    private val wordsRepository: WordsRepository,
) : BaseViewModel() {

    private val _state: MutableStateFlow<AddSetUiState> = MutableStateFlow(AddSetUiState())
    val state: StateFlow<AddSetUiState> = _state.asStateFlow()

    fun handleEvent(event: AddSetEvent) {
        when (event) {
            is AddSetEvent.AddSet -> addSet(onNavigateToHome = event.onNavigateToHome)
            is AddSetEvent.AddWord -> addWord()
            is AddSetEvent.ChangeNameSet -> changeNameSet(name = event.name)
            is AddSetEvent.ChangeWordById -> changeWordById(
                id = event.id,
                newValue = event.newValue
            )

            is AddSetEvent.ChangeTranslationById -> changeTranslationById(
                id = event.id,
                newValue = event.newValue
            )
        }
    }

    private fun changeNameSet(name: String) {
        _state.value = _state.value.copy(nameSet = name)
    }

    private fun addWord() {
        _state.value = _state.value.copy(
            wordsList = _state.value.wordsList.plus(
                Word(
                    term = "",
                    definition = ""
                )
            )
        )
    }

    private fun changeTranslationById(id: Int, newValue: String) {
        _state.value = _state.value.copy(
            wordsList = _state.value.wordsList.mapIndexed { index, word ->
                if (index == id) word.copy(definition = newValue) else word
            }
        )
    }

    private fun changeWordById(id: Int, newValue: String) {
        _state.value = _state.value.copy(
            wordsList = _state.value.wordsList.mapIndexed { index, word ->
                if (index == id) word.copy(term = newValue) else word
            }
        )
    }

    private fun addSet(onNavigateToHome: () -> Unit) {
        viewModelScope.launch {
            val wordSetId = wordSetRepository.insertWordSet(
                wordSet = WordSet(name = _state.value.nameSet)
            )

            _state.value.wordsList.forEach { word ->
                wordsRepository.insertWord(
                    word = word.copy(setId = wordSetId)
                )
            }

            onNavigateToHome.invoke()
        }
    }
}