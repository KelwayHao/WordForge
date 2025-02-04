package de.mirgorod.word.forge.feature.flashcard.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import de.mirgorod.word.forge.ui.button.KitButton
import de.mirgorod.word.forge.ui.dsComponent.Theme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import wordforge.feature.flashcard.generated.resources.Res
import wordforge.feature.flashcard.generated.resources.button_do_not_know
import wordforge.feature.flashcard.generated.resources.button_know
import wordforge.feature.flashcard.generated.resources.flashcard_progress_status

private const val CARD_ANIMATION_DURATION = 500
private const val CARD_FLIPPED_ANGLE = 180F
private const val CARD_UNFLIPPED_ANGLE = 0F
private const val MULTIPLE_CAMERA_DISTANCE = 8
private const val BASE_SCALE = 0.8F
private const val PART_CARD = 3F

@Composable
fun FlashcardContent(setId: Long) {
    val viewModel: FlashcardViewModel = koinViewModel { parametersOf(setId) }
    FlashcardContentScreen(
        state = viewModel.state.collectAsState().value,
        eventHandler = viewModel::handleEvent,
    )
}

@Composable
private fun FlashcardContentScreen(
    state: FlashcardUiState,
    eventHandler: (event: FlashcardEvent) -> Unit,
) {
    var flipped by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (flipped) CARD_FLIPPED_ANGLE else CARD_UNFLIPPED_ANGLE,
        animationSpec = tween(durationMillis = CARD_ANIMATION_DURATION),
    )
    Column(modifier = Modifier.fillMaxSize()) {
        FlashcardPlayField(
            modifier = Modifier.weight(1f),
            state = state,
            rotation = rotation,
            flipped = flipped,
            cardStateHandler = { flipped = it }
        )
        FlashcardBottomButton(
            cardStateHandler = { flipped = it },
            eventHandler = eventHandler,
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun FlashcardPlayField(
    modifier: Modifier = Modifier,
    state: FlashcardUiState,
    rotation: Float,
    flipped: Boolean,
    cardStateHandler: (state: Boolean) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            modifier = Modifier.weight(1F),
            text = stringResource(
                resource = Res.string.flashcard_progress_status,
                state.currentWordIndex.inc(),
                state.wordsList.size
            )
        )
        Card(
            elevation = 1.dp,
            modifier = Modifier.padding(all = Theme.shape.space.m)
                .weight(PART_CARD)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = MULTIPLE_CAMERA_DISTANCE * density
                },
            onClick = { cardStateHandler.invoke(!flipped) },
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(Theme.shape.space.m),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                AnimatedContent(
                    targetState = flipped,
                    transitionSpec = { fadeIn() + scaleIn(initialScale = BASE_SCALE) togetherWith fadeOut() },
                ) { isFlipped ->
                    (if (isFlipped) state.currentWord?.definition else state.currentWord?.term)?.let {
                        Text(
                            text = it,
                            modifier = Modifier.graphicsLayer {
                                rotationY =
                                    if (isFlipped) CARD_FLIPPED_ANGLE else CARD_UNFLIPPED_ANGLE
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Composable
private fun FlashcardBottomButton(
    cardStateHandler: (state: Boolean) -> Unit,
    eventHandler: (event: FlashcardEvent) -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        KitButton(
            modifier = Modifier.weight(1f)
                .padding(horizontal = Theme.shape.space.m, vertical = Theme.shape.space.s),
            text = stringResource(resource = Res.string.button_do_not_know),
            onClick = {
                cardStateHandler.invoke(false)
                eventHandler.invoke(FlashcardEvent.DoNotKnowEvent())
            }
        )
        KitButton(
            modifier = Modifier.weight(1f)
                .padding(horizontal = Theme.shape.space.m, vertical = Theme.shape.space.s),
            text = stringResource(resource = Res.string.button_know),
            onClick = {
                cardStateHandler.invoke(false)
                eventHandler.invoke(FlashcardEvent.KnowEvent())
            }
        )
    }
}
