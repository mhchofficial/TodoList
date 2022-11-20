package com.akatsuki.todolist.di


import com.akatsuki.todolist.data.local.TodoDao
import com.akatsuki.todolist.data.remote.InterfaceApi
import com.akatsuki.todolist.data.remote.repository.DataRepositorylmpl
import com.akatsuki.todolist.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideDataRepository(api: InterfaceApi, dao: TodoDao): DataRepository {
        return DataRepositorylmpl(
            api,
            dao

        )
    }


}