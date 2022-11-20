package com.akatsuki.todolist.data.remote.repository

import com.akatsuki.example_search.utils.Resource
import com.akatsuki.todolist.data.local.TodoDao
import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.data.remote.InterfaceApi
import com.akatsuki.todolist.data.remote.models.ApiResponse
import com.akatsuki.todolist.domain.repository.DataRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DataRepositorylmpl @Inject constructor(
    private val interfaceApi: InterfaceApi,
    private val Dao: TodoDao
): DataRepository {



    override suspend fun getMessage(): Flow<Resource<ApiResponse>>  = flow {
        emit(Resource.Loading())
        try {
            val data = interfaceApi.getData()
            if (data.isSuccessful){
                emit(Resource.Success(data.body()!!))
            }else{
                emit(
                    Resource.Error(
                        message = "مشکلی پیش امده",
                    )
                )
            }

        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "اینترنت قطع است",
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = "اینترنت قطع است:)",
                )
            )
        }
    }

    override suspend fun getTodos(): Flow<Resource<List<TodosModel>>> = flow{
        val data = Dao.getAllTodo()
        if (!data.isEmpty()){
            emit(Resource.Success(data))
        }else{
            emit(Resource.Error("کاری برای انجام شدن ندارید"))
        }
    }

    override suspend fun deleteTodos(id: Int){
        Dao.deleteTodo(id)

    }

    override suspend fun addTodo(id: Int, sub: String) {
        Dao.saveTodo(todosModel = TodosModel(
            id = id,
            sub = sub
        )
        )
    }


}


