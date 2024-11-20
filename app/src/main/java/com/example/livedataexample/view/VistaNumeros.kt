package com.example.livedataexample.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.livedataexample.viewmodel.NumeroViewModel

/**
 * Definim la view
 * @param myViewModel: ViewModel
 * @author RIS
 * @since 2024-11-20
 */
@Composable
fun Body(myViewModel: NumeroViewModel = NumeroViewModel()) {
    // Capturem el valor del Live Data per tal de mostrar-lo a la vista
    val valor = myViewModel.valorNumeric.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly, // Distribueix els elements de la columna ocupant tot el vertical disponible
        modifier = Modifier.fillMaxSize() // Ocupa tot l'espai disponible de l'element superior
    ) {
        Text(
            text = valor.numero.toString(), // Mostra el valor de l'artibut numero del LiveData del data class
            fontSize = 24.sp
        )

        Text(
            text = valor.positiu.toString(),  // Mostra el valor de l'artibut numero del LiveData del data class
            fontSize = 24.sp,
            color = if (valor.positiu) Color.Green else Color.Red // Canvia el color del text en funció del valor del número
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { myViewModel.onDecrementClicked() } // Crida a la funció onDecrementClicked del ViewModel
            ) {
                Text(text = "Decrementa")
            }
            Button(
                onClick = { myViewModel.onIncrementClicked() } // Crida a la funció onIncrementClicked del ViewModel
            ) {
                Text(text = "Incrementa")
            }
        }
    }
}