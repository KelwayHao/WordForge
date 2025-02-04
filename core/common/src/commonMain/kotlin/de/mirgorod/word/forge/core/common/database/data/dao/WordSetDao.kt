package de.mirgorod.word.forge.core.common.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.mirgorod.word.forge.core.common.database.data.entity.WordSetEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface WordSetDao {
    @Insert
    suspend fun insertWordSet(wordSetEntity: WordSetEntity): Long

    @Query("SELECT * FROM word_set")
    fun getAllWordSets(): Flow<List<WordSetEntity>>

    @Query("DELETE FROM word_set WHERE id = :setId")
    suspend fun deleteSetById(setId: Long)
}
