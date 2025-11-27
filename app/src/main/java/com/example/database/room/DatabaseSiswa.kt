package com.example.database.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.processor.Context


@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase() {
    abstract fun siswaDao() : SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return (Instance?: synchronized(this){
                Room.databaseBuilder(
                    context, klass=DatabaseSiswa::class.java,
                    "siswa_database")
                    .build().also{Instance=it}
            })
        }
    }
}