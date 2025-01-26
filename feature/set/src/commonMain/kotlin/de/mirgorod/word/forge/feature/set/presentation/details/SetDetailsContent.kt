package de.mirgorod.word.forge.feature.set.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.feature.set.presentation.component.WordContent
import de.mirgorod.word.forge.ui.dsComponent.Theme
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun SetDetailsContent(setId: Long) {
    val viewModel: SetDetailsViewModel = koinViewModel { parametersOf(setId) }
    SetDetailsContentScreen(
        state = viewModel.state.collectAsState().value,
        eventHandler = viewModel::handleEvent,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SetDetailsContentScreen(
    state: SetDetailsUiState,
    eventHandler: (event: SetDetailsEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(state.wordsList.size) { index ->
                val word = state.wordsList[index]
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    elevation = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Theme.color.background.secondary,
                    onClick = {  }
                ) {
                    WordContent(word = word, modifier = Modifier.padding(all = 16.dp))
                }
            }
        }
    }
}