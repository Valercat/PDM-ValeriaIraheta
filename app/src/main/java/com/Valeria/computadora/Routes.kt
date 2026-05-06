package com.Valeria.computadora

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object Home : Routes(){

    }

    @Serializable
    data object PantallaLista : Routes()

    @Serializable
    data object Sensor : Routes()

}