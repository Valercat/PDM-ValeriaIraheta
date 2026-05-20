package com.Valeria.computadora.Labo4.Screens.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NavigationScreen (navigateToDetail: () -> Unit){
    Scaffold(){
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.Center){
            Button(onClick = navigateToDetail) {
                Text("Ir a la pantalla de Task")
            }
        }
    }
}