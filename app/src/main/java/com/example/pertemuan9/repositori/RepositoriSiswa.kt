package com.example.pertemuan9.repositori

import com.example.pertemuan9.room.Siswa
import com.example.pertemuan9.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    // 1. DIPERBAIKI: Panggil fungsi dengan ()
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()

    // 2. DIPERBAIKI: Gunakan instance 'siswa' yang diterima sebagai parameter
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}