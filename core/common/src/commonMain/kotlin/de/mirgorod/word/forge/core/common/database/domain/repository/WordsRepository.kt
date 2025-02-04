package de.mirgorod.word.forge.core.common.database.domain.repository

import de.mirgorod.word.forge.core.common.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    fun getAllWords(): Flow<List<Word>>
    fun getWordsBySetId(setId: Long): Flow<List<Word>>
    suspend fun insertWord(word: Word)
    suspend fun markWordAsLearned(wordId: Long, isLearned: Boolean)
}
