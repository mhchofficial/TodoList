package com.akatsuki.todolist.ui.screens.main

import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.data.remote.models.ApiResponse

data class TodoState(
    val isLoading: Boolean = false,
    val Todos: List<TodosModel> = emptyList(),
    val error: String = "",
)