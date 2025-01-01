package de.mirgorod.word.forge.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeContent() {
    val viewModel: HomeViewModel = koinViewModel()
    HomeContentScreen(state = viewModel.state.collectAsState().value)
}

@Composable
private fun HomeContentScreen(state: HomeUiState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        state.words.forEach {
            Text(modifier = Modifier.fillMaxWidth(), text = it.word)
        }
    }
}