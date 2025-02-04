package de.mirgorod.word.forge.core.common.database.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_set")
data class WordSetEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)
