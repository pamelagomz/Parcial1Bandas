package com.pgomez.parcial1bandas.ui.band.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pgomez.parcial1bandas.BandApplication
import com.pgomez.parcial1bandas.data.models.BandModel
import com.pgomez.parcial1bandas.data.name
import com.pgomez.parcial1bandas.repositories.BandRepository

class BandViewModel(private val repository: BandRepository): ViewModel() {

    //Declaramos las variables que vamos a usar
    var name = MutableLiveData("")
    var genre = MutableLiveData("")
    var status = MutableLiveData("")

    fun getBands() = repository.getBand()

    private fun addBand(band: BandModel) = repository.addBand(band)

    fun createBand() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val band = BandModel(
            name.value!!,
            genre.value!!,

        )

        addBand(band)
        clearData()

        status.value = BAND_CREATED
    }

    fun validateData(): Boolean {
            when {
                name.value.isNullOrEmpty() -> return false
                genre.value.isNullOrEmpty() -> return false

            }
                return true
    }

    fun clearData(){

        name.value = ""
        genre.value = ""

    }

    fun clearStatus(){
        status.value = INACTIVE

    }

    fun setSelectedBand(band: BandModel) {
        name.value = band.name
        genre.value = band.genre
    }


companion object {
    val Factory = viewModelFactory {
        initializer {
            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BandApplication
            BandViewModel(app.bandRepository)
        }
    }

    const val BAND_CREATED = "Band created"
    const val WRONG_INFORMATION = "Wrong information"
    const val INACTIVE = ""
}

}