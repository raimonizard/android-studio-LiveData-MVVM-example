package com.example.livedataexample.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.livedataexample.model.Numero
import com.example.livedataexample.viewmodel.NumeroViewModel

@Composable
fun Body(myViewModel: NumeroViewModel = NumeroViewModel()) {
    //val clicksValue: Int by myViewModel.clicksValue.observeAsState(initial = 0)
    //val clicksValue by myViewModel.valorNumeric.observeAsState() // .observeAsState(initial = { Numero(0, false) })
    val valor = myViewModel.valorNumeric.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = valor.numero.toString(),
            fontSize = 24.sp
        )

        Text(
            text = valor.positiu.toString(),
            fontSize = 24.sp,
            color = if (valor.positiu) Color.Green else Color.Red
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { myViewModel.onDecrementClicked() }
            ) {
                Text(text = "Decrementa")
            }
            Button(
                onClick = { myViewModel.onIncrementClicked() }
            ) {
                Text(text = "Incrementa")
            }
        }
    }
}