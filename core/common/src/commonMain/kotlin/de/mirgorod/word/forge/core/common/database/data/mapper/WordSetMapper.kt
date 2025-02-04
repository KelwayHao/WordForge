package de.mirgorod.word.forge.core.common.database.data.mapper

import de.mirgorod.word.forge.core.common.database.data.entity.WordSetEntity
import de.mirgorod.word.forge.core.common.domain.model.WordSet

internal class WordSetMapper {
    fun mapToWordSetEntity(from: WordSet): WordSetEntity {
        return WordSetEntity(
            id = from.id ?: 0L,
            name = from.name
        )
    }

    fun mapToWordSet(from: WordSetEntity): WordSet {
        return WordSet(
            id = from.id,
            name = from.name
        )
    }
}
