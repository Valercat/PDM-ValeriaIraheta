//package com.valeria.vligcuatro
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//
//@Composable
//fun prueba(){
//Column(
//modifier = Modifier
//.fillMaxSize()
//.background(Color.Black),
//horizontalAlignment = Alignment.CenterHorizontally,
//verticalArrangement = Arrangement.Center,
//
//) {
//    val usuario: MutableState<String> = remember {
//        mutableStateOf("")
//        TextField(
//            value = usuario.value,
//            onValueChange = {
//                usuario.value = it
//            },
//        )
//    }
//
//}