package de.mirgorod.word.forge.feature.set.di

import de.mirgorod.word.forge.feature.set.presentation.details.SetDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val setModule = module {
    viewModel { (setId: Long) ->
        SetDetailsViewModel(
            setId = setId,
            wordsRepository = get(),
        )
    }
}