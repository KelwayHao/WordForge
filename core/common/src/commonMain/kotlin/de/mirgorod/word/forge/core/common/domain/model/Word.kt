package de.mirgorod.word.forge.core.common.domain.model

data class Word(
    val id: Long? = null,
    val setId: Long? = null,
    val term: String,
    val definition: String,
    val isLearned: Boolean = false,
)
