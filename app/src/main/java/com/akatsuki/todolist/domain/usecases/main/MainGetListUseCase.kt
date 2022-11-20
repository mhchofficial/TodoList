package com.akatsuki.todolist.domain.usecases.main

import com.akatsuki.example_search.utils.Resource
import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MainGetListUseCase @Inject constructor(
    private val dataRepository: DataRepository,
) {

    suspend operator fun invoke(): Flow<Resource<List<TodosModel>>> {
        return dataRepository.getTodos()
    }

}