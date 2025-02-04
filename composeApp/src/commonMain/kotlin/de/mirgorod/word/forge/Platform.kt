package de.mirgorod.word.forge

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
