package com.akatsuki.todolist.domain.usecases.main

import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class MainDeleteUseCase @Inject constructor(
    private val dataRepository: DataRepository,
) {

    suspend operator fun invoke(id: Int){
        return dataRepository.deleteTodos(id)
    }

}