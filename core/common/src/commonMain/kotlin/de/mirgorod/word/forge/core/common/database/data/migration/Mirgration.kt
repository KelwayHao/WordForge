package de.mirgorod.word.forge.core.common.database.data.migration

import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE words RENAME TO words_temp")

        connection.execSQL("""
            CREATE TABLE words (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                setId INTEGER,
                term TEXT NOT NULL,
                definition TEXT NOT NULL,
                FOREIGN KEY(setId) REFERENCES word_set(id) ON DELETE CASCADE
            )
        """.trimIndent())

        connection.execSQL("""
            INSERT INTO words (id, setId, term, definition)
            SELECT id, setId, word, translation
            FROM words_temp
        """.trimIndent())

        connection.execSQL("DROP TABLE words_temp")
    }
}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE words RENAME TO words_temp")

        connection.execSQL("""
            CREATE TABLE words (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                setId INTEGER,
                term TEXT NOT NULL,
                definition TEXT NOT NULL,
                isLearned INTEGER NOT NULL DEFAULT 0,
                FOREIGN KEY(setId) REFERENCES word_set(id) ON DELETE CASCADE
            )
        """.trimIndent())

        connection.execSQL("""
            INSERT INTO words (id, setId, term, definition, isLearned)
            SELECT id, setId, term, definition, 0 FROM words_temp
        """.trimIndent())

        connection.execSQL("DROP TABLE words_temp")
    }
}

internal val MIGRATIONS = arrayOf(MIGRATION_2_3, MIGRATION_3_4)