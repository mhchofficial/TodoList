package com.akatsuki.todolist.domain.repository


import com.akatsuki.example_search.utils.Resource

import com.akatsuki.example_search.utils.Resource.*
import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.data.remote.models.ApiResponse
import kotlinx.coroutines.flow.Flow


interface DataRepository{
    suspend fun getMessage(): Flow<Resource<ApiResponse>>

    suspend fun getTodos(): Flow<Resource<List<TodosModel>>>

    suspend fun deleteTodos(id: Int)

    suspend fun addTodo(id: Int, sub: String)


}