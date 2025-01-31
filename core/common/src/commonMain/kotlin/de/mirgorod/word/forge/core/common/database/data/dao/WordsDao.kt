package de.mirgorod.word.forge.core.common.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.mirgorod.word.forge.core.common.database.data.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface WordsDao {

    @Query("SELECT * FROM words")
    fun getAllWords(): Flow<List<WordEntity>>

    @Query("SELECT * FROM words WHERE setId = :setId")
    fun getWordsBySetId(setId: Long): Flow<List<WordEntity>>

    @Insert
    suspend fun insertWord(word: WordEntity)

    @Query("UPDATE words SET isLearned = :isLearned WHERE id = :wordId")
    suspend fun markWordAsLearned(wordId: Long, isLearned: Boolean)
}