package com.akatsuki.todolist.ui.screens.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akatsuki.example_search.utils.Resource
import com.akatsuki.todolist.domain.usecases.main.MainApiUseCase
import com.akatsuki.todolist.domain.usecases.main.MainDeleteUseCase
import com.akatsuki.todolist.domain.usecases.main.MainGetListUseCase
import com.akatsuki.todolist.domain.usecases.main.MainUseCses
import com.akatsuki.todolist.utils.loGer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainApiUseCase: MainApiUseCase,
    private val mainDeleteUseCase: MainDeleteUseCase,
    private val mainGetListUseCase: MainGetListUseCase
    ): ViewModel() {


    private val _state_del = mutableStateOf(false)
    val stateDelte: State<Boolean> = _state_del


    fun deleteTodoById(id: Int) {
        viewModelScope.launch {
            delay(500)
            mainDeleteUseCase.invoke(id).apply {
                _state_del.value = true
            }
        }

    }


    private val _state_get = mutableStateOf(TodoState())
    val stateGet: State<TodoState> = _state_get


    fun getTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            mainGetListUseCase.invoke().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state_get.value =
                            TodoState(Todos = result.data ?: emptyList())
                    }

                    is Resource.Error -> {
                        _state_get.value = TodoState(error = result.message.toString())
                    }
                    is Resource.Loading -> {
                        _state_get.value = TodoState(isLoading = true)

                    }
                }

            }
        }

    }


}