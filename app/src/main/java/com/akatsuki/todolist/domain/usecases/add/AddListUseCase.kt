package com.akatsuki.todolist.domain.usecases.add

import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class AddListUseCase @Inject constructor(
    private val dataRepository: DataRepository,
) {

    suspend operator fun invoke(id: Int, sub: String){
        return dataRepository.addTodo(id, sub)
    }

}