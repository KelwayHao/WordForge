package de.mirgorod.word.forge.core.common.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import de.mirgorod.word.forge.core.common.database.AppDatabase
import de.mirgorod.word.forge.core.common.database.data.builder.DatabaseBuilderProvider
import de.mirgorod.word.forge.core.common.database.data.mapper.WordMapper
import de.mirgorod.word.forge.core.common.database.data.mapper.WordSetMapper
import de.mirgorod.word.forge.core.common.database.data.migration.MIGRATIONS
import de.mirgorod.word.forge.core.common.database.data.repository.DefaultWordSetLocalDataSource
import de.mirgorod.word.forge.core.common.database.data.repository.DefaultWordsLocalDataSource
import de.mirgorod.word.forge.core.common.database.domain.repository.WordSetRepository
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect fun platformDatabaseModule(): Module

val databaseModule = module {
    includes(platformDatabaseModule())
    single<AppDatabase> {
        val databaseBuilderProvider: DatabaseBuilderProvider = get()
        databaseBuilderProvider.provideDatabaseBuilder()
            .addMigrations(migrations = MIGRATIONS)
            .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
            .setDriver(driver = BundledSQLiteDriver())
            .setQueryCoroutineContext(context = Dispatchers.IO)
            .build()
    }
    single<WordsRepository> {
        DefaultWordsLocalDataSource(
            appDatabase = get(),
            wordMapper = get(),
        )
    }

    single<WordSetRepository> {
        DefaultWordSetLocalDataSource(
            appDatabase = get(),
            wordSetMapper = get(),
        )
    }

    factory<WordMapper> { WordMapper() }
    factory<WordSetMapper> { WordSetMapper() }
}