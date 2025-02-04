@file:Suppress("MatchingDeclarationName")

package de.mirgorod.word.forge.core.common.database.data.builder

import androidx.room.RoomDatabase
import de.mirgorod.word.forge.core.common.database.AppDatabase

internal actual interface DatabaseBuilderProvider {
    actual fun provideDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
}
