package de.mirgorod.word.forge.core.common.database.data.repository

import de.mirgorod.word.forge.core.common.database.AppDatabase
import de.mirgorod.word.forge.core.common.database.data.mapper.WordMapper
import de.mirgorod.word.forge.core.common.database.domain.repository.WordsRepository
import de.mirgorod.word.forge.core.common.domain.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DefaultWordsLocalDataSource(
    private val appDatabase: AppDatabase,
    private val wordMapper: WordMapper,
) : WordsRepository {

    override fun getAllWords(): Flow<List<Word>> {
        return appDatabase.wordDao().getAllWords().map { wordEntities ->
            wordEntities.map { wordEntity ->
                wordMapper.mapToWord(from = wordEntity)
            }
        }
    }

    override fun getWordsBySetId(setId: Long): Flow<List<Word>> {
        return appDatabase.wordDao().getWordsBySetId(setId = setId)
            .map { it.map { wordEntity -> wordMapper.mapToWord(from = wordEntity) } }
    }

    override suspend fun insertWord(word: Word) {
        appDatabase.wordDao().insertWord(word = wordMapper.mapToWordEntity(from = word))
    }

    override suspend fun markWordAsLearned(wordId: Long, isLearned: Boolean) {
        appDatabase.wordDao().markWordAsLearned(wordId = wordId, isLearned = isLearned)
    }
}
