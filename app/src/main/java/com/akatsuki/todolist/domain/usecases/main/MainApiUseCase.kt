package com.akatsuki.todolist.domain.usecases.main

import com.akatsuki.example_search.utils.Resource
import com.akatsuki.todolist.data.remote.models.ApiResponse
import com.akatsuki.todolist.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainApiUseCase @Inject constructor(
    private val dataRepository: DataRepository,
) {

    suspend operator fun invoke(): Flow<Resource<ApiResponse>> {
        return dataRepository.getMessage()
    }

}