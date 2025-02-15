package de.mirgorod.word.forge.feature.home.presentation

import androidx.lifecycle.viewModelScope
import de.mirgorod.word.forge.core.common.database.domain.repository.WordSetRepository
import de.mirgorod.word.forge.core.common.viewmodel.BaseViewModel
import de.mirgorod.word.forge.navigation.domain.model.SetDetails
import de.mirgorod.word.forge.navigation.domain.router.NavigationRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val wordSetRepository: WordSetRepository,
    private val router: NavigationRouter,
) : BaseViewModel() {

    private val _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        startObservingWords()
    }

    fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteSet -> deleteSet(id = event.id)
            is HomeEvent.ClickSet -> onNavigateToSetDetails(id = event.id)
        }
    }

    private fun startObservingWords() {
        viewModelScope.launch {
            wordSetRepository.getAllWordSets().collectLatest { words ->
                _state.value = _state.value.copy(wordSetList = words)
            }
        }
    }

    private fun deleteSet(id: Long?) {
        if (id == null) return
        viewModelScope.launch {
            wordSetRepository.deleteWordSetById(id = id)
        }
    }

    private fun onNavigateToSetDetails(id: Long) {
        router.navigateTo(route = SetDetails(setId = id))
    }
}
