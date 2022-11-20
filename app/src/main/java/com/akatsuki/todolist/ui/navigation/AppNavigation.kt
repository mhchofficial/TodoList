package com.akatsuki.todolist.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akatsuki.todolist.ui.screens.main.MainScreen
import com.akatsuki.todolist.ui.theme.bc


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.name,
        modifier = Modifier.background(bc)){

        composable(AppScreens.MainScreen.name){
            MainScreen()
        }

    }
}