package de.mirgorod.word.forge.feature.add.set.di

import de.mirgorod.word.forge.feature.add.set.presentation.add.AddSetViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val addSetModule = module {
    viewModelOf(::AddSetViewModel)
}