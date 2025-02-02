package de.mirgorod.word.forge.navigation.domain.model

import de.mirgorod.word.forge.navigation.domain.router.RouteDestination
import kotlinx.serialization.Serializable

@Serializable
data class Flashcard(val setId: Long) : RouteDestination