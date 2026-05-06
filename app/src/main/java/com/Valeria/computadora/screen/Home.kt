package com.Valeria.computadora.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(navigateToLista: () -> Unit, navigateToSensor: () -> Unit){
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {navigateToLista()}, modifier = Modifier.weight(1f)) {
            Text("Lista")
        }
        Button(onClick = {navigateToSensor( )}, modifier = Modifier.weight(1f)) {
            Text("Sensor")
        }
    }
}