package de.mirgorod.word.forge.core.common.database.data.mapper

import de.mirgorod.word.forge.core.common.database.data.entity.WordEntity
import de.mirgorod.word.forge.core.common.domain.model.Word

internal class WordMapper {
    fun mapToWordEntity(from: Word): WordEntity {
        return WordEntity(
            id = from.id ?: 0L,
            word = from.word,
            translation = from.translation,
        )
    }

    fun mapToWord(from: WordEntity): Word {
        return Word(
            id = from.id,
            word = from.word,
            translation = from.translation,
        )
    }
}