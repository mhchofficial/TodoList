package com.akatsuki.todolist.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todos")
data class TodosModel (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int? = null,
        @ColumnInfo(name = "sub")
        val sub: String = "",



){

}