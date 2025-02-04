package de.mirgorod.word.forge.feature.set.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.core.common.domain.model.Word

@Composable
fun WordContent(
    word: Word,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = word.term)
        Spacer(modifier = Modifier.height(height = 8.dp))
        Text(text = word.definition)
    }
}
