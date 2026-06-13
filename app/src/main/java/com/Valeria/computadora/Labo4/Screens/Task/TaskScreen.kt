package com.Valeria.computadora.Labo4.Screens.Task

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.Valeria.computadora.Labo4.Components.TaskCard
import com.Valeria.computadora.Labo4.Components.CreateTask
import com.Valeria.computadora.Labo4.Model.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(navigateBack: () -> Unit, viewModel: TaskViewModel = viewModel()){
    val tasks by viewModel.tasks.collectAsState(initial = emptyList())

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Tasks list")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {showDialog = true}) {
                Icon(Icons.Default.Add, contentDescription = "Añadir")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(tasks){ task ->
                TaskCard(task)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        if (showDialog){
            CreateTask(
                onDismiss = { showDialog = false },
                onTaskCreated = { newTitle, newDescription ->
                    val newTask = Task(
                        id = (System.currentTimeMillis() % Int.MAX_VALUE).toInt(),
                        title = newTitle,
                        description = newDescription
                    )
                    viewModel.addTask(newTask)
                    showDialog = false
                }
            )
        }
    }
}