package com.example.livedataexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// Per poder usar el MVVM
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
//import androidx.viewbinding.ViewBinding
import com.example.livedataexample.ui.theme.LiveDataExampleTheme
// Per importar totes les vistes creades
import com.example.livedataexample.view.*
// Per importar tots els ViewModels creats
import com.example.livedataexample.viewmodel.*

/**
 * Aquest és l'entry point de la app des d'on s'inicia.
 * @author RIS
 * @since 2024-11-20
 */
class MainActivity : ComponentActivity() {
    // Definim la constant que farà referència al View Model declarat
    val numeroViewModel: NumeroViewModel by viewModels<NumeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LiveDataExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Crida a la vista que es vol renderitzar passant-li el ViewModel
                    Body(numeroViewModel)
                }
            }
        }
    }
}