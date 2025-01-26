package de.mirgorod.word.forge.core.common.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import de.mirgorod.word.forge.core.common.database.data.dao.WordSetDao
import de.mirgorod.word.forge.core.common.database.data.dao.WordsDao
import de.mirgorod.word.forge.core.common.database.data.entity.WordEntity
import de.mirgorod.word.forge.core.common.database.data.entity.WordSetEntity

@Database(
    entities = [WordEntity::class, WordSetEntity::class],
    version = 3
)
@ConstructedBy(AppDatabaseConstructor::class)
internal abstract class AppDatabase : RoomDatabase() {
    internal abstract fun wordDao(): WordsDao
    internal abstract fun wordSetDao(): WordSetDao
}