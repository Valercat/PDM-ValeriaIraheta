package com.valeria.vligcuatro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valeria.vligcuatro.ui.theme.VLIGCUATROTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VLIGCUATROTheme {
                IngresoTexto()
            }
        }
    }
}


@Composable
fun IngresoTexto() {
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
                    Text(stringResource(R.string.lista))
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VLIGCUATROTheme {

       IngresoTexto()

    }
}