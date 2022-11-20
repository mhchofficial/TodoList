package com.akatsuki.todolist.ui.screens.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akatsuki.example_search.utils.Resource
import com.akatsuki.todolist.domain.usecases.main.MainApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainApiViewModel @Inject constructor(
    private val mainApiUseCase: MainApiUseCase
): ViewModel() {

    private val _state_api = mutableStateOf(ApiState())
    val stateApi: State<ApiState> = _state_api

    fun getHadis() {
        viewModelScope.launch(Dispatchers.IO) {

            mainApiUseCase.invoke().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state_api.value = ApiState(response = result.data)
                    }

                    is Resource.Error -> {
                        _state_api.value = ApiState(error = result.message.toString())
                    }
                    is Resource.Loading -> {
                        _state_api.value = ApiState(isLoading = true)

                    }
                }

            }
        }


    }
}