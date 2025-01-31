package de.mirgorod.word.forge.feature.flashcard.presentation

internal sealed class FlashcardEvent {
    class KnowEvent: FlashcardEvent()
    class DoNotKnowEvent: FlashcardEvent()
}