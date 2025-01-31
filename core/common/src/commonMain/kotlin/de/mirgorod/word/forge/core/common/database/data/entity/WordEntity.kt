package de.mirgorod.word.forge.core.common.database.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "words",
    foreignKeys = [ForeignKey(
        entity = WordSetEntity::class,
        parentColumns = ["id"],
        childColumns = ["setId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val setId: Long? = null,
    val term: String,
    val definition: String,
    val isLearned: Boolean = false,
)