package com.example.livedataexample.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedataexample.model.Numero

/**
 * Aquest és ViewModel (Controlador) que usarem per a gestionar les dades del data class Valor
 * Per tal de que la classe que conté aquest fitxer sigui contemplada com a ViewModel, ha d'heretar de la classe ViewModel.
 * Per aquest motiu hem posat ViewMoldel() aquí -> class ValorViewModel: ViewModel() {
 */
class NumeroViewModel: ViewModel() {
    // Declarem un atribut del ViewModel anomenat valorNumeric del tipus de dades MutableLiveData
    // Això ens permetrà que la app pugui consultar el seu valor i saber quan canvia.
    // L'inicialitzem amb uns valors per defecte
    ////val _valorNumeric = MutableLiveData<Numero>(Numero(0, true))
    //val valorNumeric = _valorNumeric
    ////val valorNumeric: LiveData<Numero> get() = _valorNumeric

    val valorNumeric = mutableStateOf(Numero(0, false))

    fun getNumero(): Int{
        if (valorNumeric.value == null)
            return 0
        else
            return valorNumeric.value!!.numero
    }

    fun getPositiu(): Boolean{
        if (valorNumeric.value == null)
            return false
        else
            return valorNumeric.value!!.positiu
    }

    fun onIncrementClicked() {
        valorNumeric.value?.numero  = valorNumeric.value?.numero!!.plus(1)

        if (valorNumeric.value?.numero!! >= 0)
            valorNumeric.value?.positiu = true
    }

    fun onDecrementClicked() {
        valorNumeric.value?.numero  = valorNumeric.value?.numero!!.minus(1)

        if (valorNumeric.value?.numero!! < 0)
            valorNumeric.value?.positiu = false
    }
}