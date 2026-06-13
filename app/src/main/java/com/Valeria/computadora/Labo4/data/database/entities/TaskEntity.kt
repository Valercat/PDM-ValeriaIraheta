package com.Valeria.computadora.Labo4.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.Valeria.computadora.Labo4.Model.Task
import java.util.Date

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey val id: Int,
    val title: String,
    val content: String,
    val endDate: Long,
    val isCompleted: Boolean = false
)

fun Post.toModel(): Task {
    return Task(
        id = id,
        title = title,
        description = content,
        endDate = Date(endDate),
        isCompleted = isCompleted
    )
}

fun Task.toEntity(): Post {
    return Post(
        id = id,
        title = title,
        content = description,
        endDate = endDate.time,
        isCompleted = isCompleted
    )
}
