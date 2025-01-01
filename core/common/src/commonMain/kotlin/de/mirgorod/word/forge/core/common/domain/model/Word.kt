package de.mirgorod.word.forge.core.common.domain.model

data class Word(
    val id: Long? = null,
    val word: String,
    val translation: String,
)