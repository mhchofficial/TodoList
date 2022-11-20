package com.akatsuki.todolist.data.remote.models


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("Author")
    val author: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("updated_at")
    val updatedAt: String
)