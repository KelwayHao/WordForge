package de.mirgorod.word.forge.core.common.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.mirgorod.word.forge.core.common.database.data.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface WordsDao {
    @Insert
    suspend fun insertWord(word: WordEntity)

    @Query("SELECT * FROM words_table")
    fun getAllWords(): Flow<List<WordEntity>>
}