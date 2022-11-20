package com.akatsuki.todolist.ui.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akatsuki.todolist.domain.usecases.add.AddListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddViewModel @Inject constructor(
    private val addListUseCase: AddListUseCase
    ): ViewModel() {

    fun AddTodo(id: Int, sub: String) {
        viewModelScope.launch {
            addListUseCase.invoke(id, sub)
        }

    }


}