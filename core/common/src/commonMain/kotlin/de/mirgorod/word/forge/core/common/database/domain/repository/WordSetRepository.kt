package de.mirgorod.word.forge.core.common.database.domain.repository

import de.mirgorod.word.forge.core.common.domain.model.WordSet
import kotlinx.coroutines.flow.Flow

interface WordSetRepository {
    fun getAllWordSets(): Flow<List<WordSet>>
    suspend fun insertWordSet(wordSet: WordSet): Long
    suspend fun deleteWordSetById(id: Long)
}