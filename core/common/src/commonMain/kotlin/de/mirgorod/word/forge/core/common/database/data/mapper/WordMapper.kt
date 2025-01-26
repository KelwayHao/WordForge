package de.mirgorod.word.forge.core.common.database.data.mapper

import de.mirgorod.word.forge.core.common.database.data.entity.WordEntity
import de.mirgorod.word.forge.core.common.domain.model.Word

internal class WordMapper {
    fun mapToWordEntity(from: Word): WordEntity {
        return WordEntity(
            id = from.id ?: 0L,
            term = from.term,
            definition = from.definition,
            setId = from.setId,
        )
    }

    fun mapToWord(from: WordEntity): Word {
        return Word(
            id = from.id,
            term = from.term,
            definition = from.definition,
            setId = from.setId,
        )
    }
}