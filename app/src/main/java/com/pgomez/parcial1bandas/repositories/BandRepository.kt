package com.pgomez.parcial1bandas.repositories

import com.pgomez.parcial1bandas.data.models.BandModel

class BandRepository(private val bands: MutableList<BandModel>) {
    fun getBand() = bands


    // add a new band to the list of bands dummyData.kt
    fun addBand(band: BandModel) = bands.add(band)
}