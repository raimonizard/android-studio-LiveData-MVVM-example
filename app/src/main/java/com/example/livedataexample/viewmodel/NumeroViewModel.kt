package com.example.livedataexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedataexample.model.Numero

/**
 * Aquest és ViewModel (Controlador) que usarem per a gestionar les dades del data class Valor
 * Per tal de que la classe que conté aquest fitxer sigui contemplada com a ViewModel, ha d'heretar de la classe ViewModel.
 * Per aquest motiu hem posat ViewMoldel() aquí -> class ValorViewModel: ViewModel() {
 */
class NumeroViewModel : ViewModel() {
    // A aquesta variable només s'hi pot accedir des del ViewModel
    private val _valorNumeric = MutableLiveData(Numero(0, true))

    // Aquesta variable és pública i és la que està disponible a la vista
    // Estarà constantment pendent dels canvis que hi hagi a la vista
    // Cada vegada que hi hagi un canvi a la vista (girar pantalla, click, etc.) capturarà de nou el valor que tingui l'objecte _valorNumeric
    val valorNumeric: LiveData<Numero> = _valorNumeric

    /**
     * Funció que es llançarà al apretat el butó de Decrementa
     */
    fun onIncrementClicked() {
        val currentNumero = _valorNumeric.value ?: Numero(0, true)
        _valorNumeric.value = currentNumero.copy(
            numero = currentNumero.numero + 1,
            positiu = currentNumero.numero + 1 >= 0
        )
    }

    /**
     * Funció que es llançarà al apretat el butó de Incrementa
     */
    fun onDecrementClicked() {
        val currentNumero = _valorNumeric.value ?: Numero(0, true)
        _valorNumeric.value = currentNumero.copy(
            numero = currentNumero.numero - 1,
            positiu = currentNumero.numero - 1 >= 0
        )
    }
}