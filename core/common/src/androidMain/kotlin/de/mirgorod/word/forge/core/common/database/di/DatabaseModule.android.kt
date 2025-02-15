package de.mirgorod.word.forge.core.common.database.di

import de.mirgorod.word.forge.core.common.database.data.builder.DatabaseBuilderAndroid
import de.mirgorod.word.forge.core.common.database.data.builder.DatabaseBuilderProvider
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun platformDatabaseModule(): Module = module {
    single<DatabaseBuilderProvider> {
        DatabaseBuilderAndroid(context = get())
    }
}
