package de.mirgorod.word.forge.feature.add.set.presentation.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.ui.button.KitButton
import de.mirgorod.word.forge.ui.dsComponent.Theme
import de.mirgorod.word.forge.ui.textfield.KitOutlinedTextField
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wordforge.feature.add_set.generated.resources.Res
import wordforge.feature.add_set.generated.resources.add_set_button
import wordforge.feature.add_set.generated.resources.add_term_button
import wordforge.feature.add_set.generated.resources.definition_label
import wordforge.feature.add_set.generated.resources.set_name_label
import wordforge.feature.add_set.generated.resources.term_label
import wordforge.feature.add_set.generated.resources.term_title

@Composable
fun AddSetContent(onNavigateToHome: () -> Unit) {
    val viewModel: AddSetViewModel = koinViewModel()
    AddSetContentScreen(
        state = viewModel.state.collectAsState().value,
        eventHandler = viewModel::handleEvent,
        onNavigateToHome = onNavigateToHome,
    )
}

@Composable
private fun AddSetContentScreen(
    state: AddSetUiState,
    eventHandler: (event: AddSetEvent) -> Unit,
    onNavigateToHome: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AddSetNameField(state = state, eventHandler = eventHandler)
        AddSetWordsList(
            state = state,
            eventHandler = eventHandler,
            onNavigateToHome = onNavigateToHome
        )
    }
}

@Composable
private fun AddSetWordsList(
    state: AddSetUiState,
    eventHandler: (event: AddSetEvent) -> Unit,
    onNavigateToHome: () -> Unit,
) {
    LazyColumn {
        items(state.wordsList.size) { index ->
            AddSetWordItem(
                index = index,
                state = state,
                eventHandler = eventHandler
            )
        }
        item {
            AddSetBottomButtons(
                eventHandler = eventHandler,
                onNavigateToHome = onNavigateToHome
            )
        }
    }
}

@Composable
private fun AddSetWordItem(
    index: Int,
    state: AddSetUiState,
    eventHandler: (event: AddSetEvent) -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Theme.color.background.secondary
    ) {
        Column(modifier = Modifier.padding(all = 16.dp)) {
            Text(text = stringResource(Res.string.term_title, index.inc()))
            KitOutlinedTextField(
                modifier = Modifier.padding(vertical = 8.dp),
                value = state.wordsList[index].term,
                onValueChange = {
                    eventHandler.invoke(
                        AddSetEvent.ChangeWordById(
                            id = index,
                            newValue = it
                        )
                    )
                },
                label = { Text(text = stringResource(resource = Res.string.term_label)) }
            )
            KitOutlinedTextField(
                modifier = Modifier.padding(vertical = 8.dp),
                value = state.wordsList[index].definition,
                onValueChange = {
                    eventHandler.invoke(
                        AddSetEvent.ChangeTranslationById(
                            id = index,
                            newValue = it
                        )
                    )
                },
                label = { Text(text = stringResource(resource = Res.string.definition_label)) }
            )
        }
    }
}

@Composable
private fun AddSetNameField(
    state: AddSetUiState,
    eventHandler: (event: AddSetEvent) -> Unit,
) {
    KitOutlinedTextField(
        modifier = Modifier.padding(all = 16.dp),
        value = state.nameSet,
        onValueChange = { eventHandler.invoke(AddSetEvent.ChangeNameSet(name = it)) },
        label = { Text(text = stringResource(resource = Res.string.set_name_label)) }
    )
}

@Composable
private fun AddSetBottomButtons(
    eventHandler: (event: AddSetEvent) -> Unit,
    onNavigateToHome: () -> Unit,
) {
    KitButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(resource = Res.string.add_term_button),
        onClick = { eventHandler.invoke(AddSetEvent.AddWord()) },
    )
    KitButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(resource = Res.string.add_set_button),
        onClick = { eventHandler.invoke(AddSetEvent.AddSet(onNavigateToHome = onNavigateToHome)) },
    )
}