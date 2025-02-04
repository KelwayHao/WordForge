package de.mirgorod.word.forge.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.ui.dsComponent.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KitButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    shape: Shape = RoundedCornerShape(8.dp),
    elevation: ButtonElevation? = ButtonDefaults.elevation(defaultElevation = 4.dp),
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = PaddingValues(all = 16.dp),
        content = {
            Text(
                text = text,
                style = Theme.typography.action.primaryMedium,
                color = Theme.color.text.primaryInverted
            )
        },
        shape = shape,
        colors = colors,
        elevation = elevation,
    )
}

@Suppress("UnusedPrivateMember")
@Preview
@Composable
private fun KitButtonPreview() {
    KitButton(
        text = "KitButton",
        onClick = { },
    )
}
