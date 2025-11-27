package com.example.database.viewmodel

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)



fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
)