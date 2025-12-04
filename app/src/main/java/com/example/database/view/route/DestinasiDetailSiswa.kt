package com.example.myroomsiswa.view.route

import com.example.database.R
import com.example.database.view.route.DestinasiNavigasi


object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}