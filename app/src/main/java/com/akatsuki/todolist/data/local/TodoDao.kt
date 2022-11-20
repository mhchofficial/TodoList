package com.akatsuki.todolist.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.akatsuki.todolist.data.local.model.TodosModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    fun getAllTodo(): List<TodosModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTodo(todosModel: TodosModel)

    @Query("DELETE FROM todos WHERE id==:id")
    suspend fun deleteTodo(id: Int)

    @Query("DELETE FROM todos")
    suspend fun deleteTodos()

    @Query("SELECT * FROM todos WHERE id = :id")
    fun getUserById(id: Int): LiveData<TodosModel>







}
