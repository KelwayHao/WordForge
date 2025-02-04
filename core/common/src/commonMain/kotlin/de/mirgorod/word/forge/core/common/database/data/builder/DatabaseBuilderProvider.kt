package de.mirgorod.word.forge.core.common.database.data.builder

import androidx.room.RoomDatabase
import de.mirgorod.word.forge.core.common.database.AppDatabase

internal expect interface DatabaseBuilderProvider {
    fun provideDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
}
