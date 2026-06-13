package com.Valeria.computadora

import android.app.Application

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.room.Room
import com.Valeria.computadora.data.database.AppDatabase
import com.Valeria.computadora.screen.Home
import com.Valeria.computadora.screen.Lista.IngresoTexto
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

class InitDatabase : Application() {
    companion object{
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AppDatabase"
        ).fallbackToDestructiveMigration(false).build()
    }
}