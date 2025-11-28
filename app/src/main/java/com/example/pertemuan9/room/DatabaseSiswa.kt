package com.example.pertemuan9.room

import android.content.Context
import androidx.room.Database // Import yang benar
import androidx.room.Room // Import yang benar
import androidx.room.RoomDatabase

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase() {

    abstract fun SiswaDao(): SiswaDao

    companion object {
        @Volatile
        private var instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseSiswa::class.java,
                    "siswa_database"
                )
                    .build()
                    .also { instance = it }
            }
        }
    }
}