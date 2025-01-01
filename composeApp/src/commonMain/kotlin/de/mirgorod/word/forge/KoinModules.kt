package de.mirgorod.word.forge

import de.mirgorod.word.forge.core.common.database.di.databaseModule
import de.mirgorod.word.forge.feature.home.di.homeModule
import org.koin.core.module.Module

internal fun koinModules(platformModule: Module) = listOf(
    platformModule,
    homeModule,
    databaseModule,
)