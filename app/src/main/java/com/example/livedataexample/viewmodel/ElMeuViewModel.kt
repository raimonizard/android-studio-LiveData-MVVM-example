package com.example.livedataexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElMeuViewModel: ViewModel() {
    private val _clicksValue = MutableLiveData<Int>(0)
    val clicksValue = _clicksValue

    fun onIncrementClicked() {
        _clicksValue.value = _clicksValue.value?.plus(1)
    }

    fun onDecrementClicked() {
        _clicksValue.value = _clicksValue.value?.minus(1)
    }
}