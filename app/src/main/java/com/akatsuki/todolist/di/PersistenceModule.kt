package com.akatsuki.todolist.di

import android.content.Context
import androidx.room.Room
import com.akatsuki.todolist.data.local.AppDatabase
import com.akatsuki.todolist.data.local.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "todos_users")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideBookmarkDao(appDatabase: AppDatabase) : TodoDao {
        return appDatabase.dao()
    }
}