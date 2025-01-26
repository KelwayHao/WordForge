package de.mirgorod.word.forge.core.common.database.data.repository

import de.mirgorod.word.forge.core.common.database.AppDatabase
import de.mirgorod.word.forge.core.common.database.data.mapper.WordSetMapper
import de.mirgorod.word.forge.core.common.database.domain.repository.WordSetRepository
import de.mirgorod.word.forge.core.common.domain.model.WordSet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DefaultWordSetLocalDataSource(
    private val appDatabase: AppDatabase,
    private val wordSetMapper: WordSetMapper,
) : WordSetRepository {

    override fun getAllWordSets(): Flow<List<WordSet>> {
        return appDatabase.wordSetDao().getAllWordSets()
            .map { it.map { wordSetEntity -> wordSetMapper.mapToWordSet(from = wordSetEntity) } }
    }

    override suspend fun insertWordSet(wordSet: WordSet): Long {
        return appDatabase.wordSetDao()
            .insertWordSet(wordSetEntity = wordSetMapper.mapToWordSetEntity(from = wordSet))
    }

    override suspend fun deleteWordSetById(id: Long) {
        appDatabase.wordSetDao().deleteSetById(setId = id)
    }
}