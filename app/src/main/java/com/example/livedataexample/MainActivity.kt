package com.example.livedataexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.livedataexample.ui.theme.LiveDataExampleTheme
import com.example.livedataexample.view.*
import com.example.livedataexample.viewmodel.ValorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Definim la constant que farà referència al View Model declarat
        val valorViewModel: ValorViewModel by viewModels<ValorViewModel>()

        setContent {
            LiveDataExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body(valorViewModel)
                }
            }
        }
    }
}