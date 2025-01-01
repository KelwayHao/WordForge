package de.mirgorod.word.forge.core.common.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import de.mirgorod.word.forge.core.common.database.data.dao.WordsDao
import de.mirgorod.word.forge.core.common.database.data.entity.WordEntity

@Database(
    entities = [WordEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
internal abstract class AppDatabase: RoomDatabase() {
    internal abstract fun wordDao(): WordsDao
}