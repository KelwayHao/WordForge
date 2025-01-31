package de.mirgorod.word.forge.feature.flashcard.di

import de.mirgorod.word.forge.feature.flashcard.presentation.FlashcardViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val flashcardModule = module {
    viewModel { (setId: Long) ->
        FlashcardViewModel(
            setId = setId,
            wordsRepository = get(),
        )
    }
}