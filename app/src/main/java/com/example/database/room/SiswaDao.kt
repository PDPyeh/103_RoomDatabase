package com.example.database.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SiswaDao {
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun
}