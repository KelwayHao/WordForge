package de.mirgorod.word.forge.core.common.database.data.builder

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import de.mirgorod.word.forge.core.common.database.AppDatabase

internal class DatabaseBuilderAndroid(
    private val context: Context,
) : DatabaseBuilderProvider {
    override fun provideDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("word_forge.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath,
        )
    }
}
