package com.Valeria.computadora.Labo4.Screens.Task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Valeria.computadora.Labo4.Model.Task
import com.Valeria.computadora.Labo4.data.InitDatabase
import com.Valeria.computadora.Labo4.data.database.entities.toEntity
import com.Valeria.computadora.Labo4.data.database.entities.toModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val dao = InitDatabase.database.postDao()

    val tasks = dao.getAllPosts().map { list ->
        list.map { it.toModel() }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            dao.insertPost(task.toEntity())
        }
    }
}
