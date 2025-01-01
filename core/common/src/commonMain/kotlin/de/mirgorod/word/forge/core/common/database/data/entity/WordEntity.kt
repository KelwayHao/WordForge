package de.mirgorod.word.forge.core.common.database.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
internal data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val word: String,
    val translation: String,
)