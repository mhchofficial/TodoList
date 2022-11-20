package com.akatsuki.todolist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akatsuki.todolist.data.local.model.TodosModel

@Database(entities = [TodosModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao() : TodoDao
}