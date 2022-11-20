package com.akatsuki.todolist.domain.usecases.main

import com.akatsuki.todolist.domain.usecases.add.AddListUseCase

data class MainUseCses (
    val addListUseCase : AddListUseCase,
    val mainGetListUseCase: MainGetListUseCase,
    val mainDeleteUseCase: MainDeleteUseCase,
    val mainApiUseCase: MainApiUseCase
)