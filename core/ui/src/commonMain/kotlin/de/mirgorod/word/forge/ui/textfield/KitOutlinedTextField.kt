package de.mirgorod.word.forge.ui.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.mirgorod.word.forge.ui.dsComponent.Theme

@Composable
fun KitOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = label,
        singleLine = singleLine,
        colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Theme.color.background.primary)
    )
}