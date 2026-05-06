package com.Valeria.computadora

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.Valeria.computadora.screen.Home
import com.Valeria.computadora.screen.IngresoTexto
import com.Valeria.computadora.screen.LightSensor

@Composable
fun App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<Routes.Home> {
                Home(
                    navigateToLista = {
                        backStack.add(Routes.PantallaLista)
                    },
                    navigateToSensor = {
                        backStack.add(Routes.Sensor)
                    }
                )
            }

            entry<Routes.PantallaLista> {
                IngresoTexto(
                    navigateBack = { backStack.removeLastOrNull() },

                )
            }
            entry<Routes.Sensor> {
                LightSensor(
                    navigateBack = { backStack.removeLastOrNull() },

                    )
            }
        }
    )
}