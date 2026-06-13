package com.Valeria.computadora.Labo4

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.Valeria.computadora.Labo4.Screens.Navigation.NavigationScreen
import com.Valeria.computadora.Labo4.Screens.Task.TaskScreen

@Composable
fun App() {
    val backStack = rememberNavBackStack(Routes.Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                NavigationScreen(
                    navigateToDetail = { backStack.add(Routes.Task) }
                )
            }
            entry<Routes.Task> {
                TaskScreen(
                    navigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}