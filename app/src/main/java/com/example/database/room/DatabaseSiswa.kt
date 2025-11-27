package com.example.database.room

import androidx.room.Database


@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa {
}