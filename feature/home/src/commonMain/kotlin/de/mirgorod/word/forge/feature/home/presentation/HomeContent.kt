package de.mirgorod.word.forge.feature.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.ui.dsComponent.Theme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wordforge.feature.home.generated.resources.Res
import wordforge.feature.home.generated.resources.ic_close_24
import wordforge.feature.home.generated.resources.word_set_title

@Composable
fun HomeContent(onNavigateToSetDetails: (Long) -> Unit) {
    val viewModel: HomeViewModel = koinViewModel()
    HomeContentScreen(
        state = viewModel.state.collectAsState().value,
        eventHandler = viewModel::handleEvent,
        onNavigateToSetDetails = onNavigateToSetDetails
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun HomeContentScreen(
    state: HomeUiState,
    eventHandler: (event: HomeEvent) -> Unit,
    onNavigateToSetDetails: (Long) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                item {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(all = 16.dp),
                        text = stringResource(resource = Res.string.word_set_title),
                        color = Theme.color.text.primary,
                        style = Theme.typography.headline.large,
                        maxLines = 1,
                        overflow = TextOverflow.Clip,
                    )
                }
                items(state.wordSetList.size) { index ->
                    Card(modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                        elevation = 1.dp,
                        shape = RoundedCornerShape(16.dp),
                        backgroundColor = Theme.color.background.secondary,
                        onClick = {
                            onNavigateToSetDetails.invoke(
                                state.wordSetList[index].id ?: 0L
                            )
                        }) {
                        Column(modifier = Modifier.padding(all = 16.dp)) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = state.wordSetList[index].name,
                                    color = Theme.color.text.primary,
                                    style = Theme.typography.paragraph.primaryMedium,
                                    maxLines = 1,
                                    overflow = TextOverflow.Clip,
                                )
                                IconButton(modifier = Modifier.background(
                                    color = Theme.color.background.primary,
                                    shape = RoundedCornerShape(size = Theme.shape.radius.l)
                                ), onClick = {
                                    eventHandler.invoke(
                                        HomeEvent.DeleteSet(id = state.wordSetList[index].id)
                                    )
                                }) {
                                    Icon(
                                        painter = painterResource(resource = Res.drawable.ic_close_24),
                                        contentDescription = null,
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
                item { Spacer(modifier = Modifier.height(height = 80.dp)) }
            }
        }
    }
}