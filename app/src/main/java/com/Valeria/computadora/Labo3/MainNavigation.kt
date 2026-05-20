package com.Valeria.computadora.Labo3

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.Valeria.computadora.Labo3.screen.Home
import com.Valeria.computadora.Labo3.screen.IngresoTexto
import com.Valeria.computadora.Labo3.screen.LightSensor

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