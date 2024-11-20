package com.example.livedataexample.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.livedataexample.model.Numero
import com.example.livedataexample.viewmodel.NumeroViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign

/**
 * Definim la view
 * @param myViewModel: ViewModel
 * @author RIS
 * @since 2024-11-20
 */
@Composable
fun Body(myViewModel: NumeroViewModel) {
    // Capturem el valor del Live Data per tal de mostrar-lo a la vista
    val valor by myViewModel.valorNumeric.observeAsState(initial = Numero(0, true))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly, // Distribueix els elements de la columna ocupant tot el vertical disponible
        modifier = Modifier.fillMaxSize() // Ocupa tot l'espai disponible de l'element superior
    ) {
        Text(
            text = "Exemple LiveData amb Compose MVVM",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Valor actual:",
                fontSize = 20.sp
            )

            Text(
                text = valor.numero.toString(), // Mostra el valor de l'artibut numero del LiveData del data class
                fontSize = 20.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {

        Text(
            text = "És positiu? ",
            fontSize = 20.sp
        )

        Text(
            text = valor.positiu.toString(),  // Mostra el valor de l'artibut numero del LiveData del data class
            fontSize = 20.sp,
            color = if (valor.positiu) Color.Green else Color.Red // Canvia el color del text en funció del valor del número
        )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { myViewModel.onDecrementClicked() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Decrementa")
            }
            Button(
                onClick = { myViewModel.onIncrementClicked() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Incrementa")
            }
        }
    }
}