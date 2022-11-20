package com.akatsuki.todolist.ui.screens.main

import com.akatsuki.todolist.data.remote.models.ApiResponse

data class ApiState(
    val isLoading: Boolean = false,
    val response: ApiResponse? = null,
    val error: String = ""
)