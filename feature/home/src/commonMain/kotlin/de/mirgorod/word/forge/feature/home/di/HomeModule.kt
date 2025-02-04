package de.mirgorod.word.forge.feature.home.di

import de.mirgorod.word.forge.feature.home.presentation.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
}
