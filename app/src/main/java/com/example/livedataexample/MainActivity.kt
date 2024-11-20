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


class MainActivity : ComponentActivity() {
    // private lateinit var binding: ViewBinding

    // Definim la constant que farà referència al View Model declarat
    val numeroViewModel: NumeroViewModel by viewModels<NumeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ///binding = ViewBinding.inflate(layoutInflater)

        setContent {
            LiveDataExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body(numeroViewModel)
                }
            }
        }
    }
}