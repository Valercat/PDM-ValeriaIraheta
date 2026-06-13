package com.Valeria.computadora.screen.Lista

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.unit.dp

@Composable
fun IngresoTexto(navigateBack: () -> Unit) {
    val listaUsuario = remember { mutableStateListOf("") }
    val usuario: MutableState<String> = remember {mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextButton(
            onClick = { navigateBack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar al Menú")
        }
        TextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            label = {Text("Usuario")},
            value = usuario.value,
            onValueChange = {
                usuario.value = it
            }
        )
        Button(
            onClick = {
                listaUsuario.add(usuario.value)
                usuario.value = ""
            }
        ) {
            Text(text = "Guardar")
        }


        Column(    modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp)
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box() {
                Row() {
                    Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.CenterStart) {
                        Text("Lista")
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        Button(
                            onClick = {
                                listaUsuario.clear()
                            }
                        ) {
                            Text(text = "Limpiar")
                        }
                    }
                }
            }
            Box() {
                LazyColumn(modifier = Modifier.border(width = 3.dp, color = Blue).fillMaxHeight()) {
                    itemsIndexed(listaUsuario.toList()) { index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = item
                            )
                            Text(
                                text = (index + 1).toString()
                            )
                        }
                    }
                }

            }
        }

    }
}
