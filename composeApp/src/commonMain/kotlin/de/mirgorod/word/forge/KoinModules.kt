package de.mirgorod.word.forge

import de.mirgorod.word.forge.core.common.database.di.databaseModule
import de.mirgorod.word.forge.feature.add.set.di.addSetModule
import de.mirgorod.word.forge.feature.flashcard.di.flashcardModule
import de.mirgorod.word.forge.feature.home.di.homeModule
import de.mirgorod.word.forge.feature.set.di.setModule
import org.koin.core.module.Module

internal fun koinModules(platformModule: Module, navigationModule: Module) = listOf(
    platformModule,
    navigationModule,
    homeModule,
    databaseModule,
    addSetModule,
    setModule,
    flashcardModule,
)
