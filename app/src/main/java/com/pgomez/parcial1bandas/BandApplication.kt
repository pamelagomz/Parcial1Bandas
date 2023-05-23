package com.pgomez.parcial1bandas

import android.app.Application
import com.pgomez.parcial1bandas.data.bands
import com.pgomez.parcial1bandas.repositories.BandRepository

class BandApplication: Application() {
    val bandRepository: BandRepository by lazy {
        BandRepository(bands)
    }
}