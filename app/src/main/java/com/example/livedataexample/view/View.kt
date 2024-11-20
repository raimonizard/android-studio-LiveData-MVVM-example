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
import androidx.compose.ui.unit.sp
import com.example.livedataexample.viewmodel.ElMeuViewModel
import com.example.livedataexample.viewmodel.ValorViewModel

@Composable
fun Body(myViewModel: ElMeuViewModel) {
    val clicksValue: Int by myViewModel.clicksValue.observeAsState(initial = 0)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = clicksValue.toString(), fontSize = 24.sp)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { myViewModel.onDecrementClicked() }) {
                Text(text = "Decrementa")
            }
            Button(onClick = { myViewModel.onIncrementClicked() }) {
                Text(text = "Incrementa")
            }
        }
    }
}