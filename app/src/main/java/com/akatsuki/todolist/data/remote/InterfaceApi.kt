package com.akatsuki.todolist.data.remote


import com.akatsuki.todolist.data.remote.models.ApiResponse
import retrofit2.Response
import retrofit2.http.*

interface InterfaceApi {

    @GET("index")
    suspend fun getData(
    ): Response<ApiResponse>




}