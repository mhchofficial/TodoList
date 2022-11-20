package com.akatsuki.todolist.ui.screens.main

import android.annotation.SuppressLint
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.akatsuki.example_search.utils.Resource
import com.akatsuki.todolist.data.remote.models.ApiResponse
import com.akatsuki.todolist.ui.component.ItemScreen
import com.akatsuki.todolist.ui.component.TopAppScreen
import com.akatsuki.todolist.ui.screens.add.AddTodo_Screen
import com.akatsuki.todolist.ui.theme.*
import com.akatsuki.todolist.utils.Constant.TAG
import com.akatsuki.todolist.utils.loGer

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    mainApiViewModel: MainApiViewModel = hiltViewModel()
){

    val open_ScreenAdd = remember {
        mutableStateOf(false)
    }

    val last_id = remember {
        mutableStateOf(0)
    }

    val delete_id = remember {
        mutableStateOf(0)
    }


    val isEmpty = remember {
        mutableStateOf(false)
    }

    val delete = remember {
        mutableStateOf(false)
    }

    val reload = remember {
        mutableStateOf(false)
    }


    val state = mainApiViewModel.stateApi.value
    val todos = mainViewModel.stateGet.value


    LaunchedEffect(true) {
        mainApiViewModel.getHadis()


    }

    if (todos.Todos.isNotEmpty()){
        last_id.value = todos.Todos.last().id!!
        isEmpty.value = false
    }else{
        isEmpty.value = true
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bc)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(bc),
            ) {



                if (state.response != null) {

                    TopAppScreen(modifier = Modifier, data = state.response)
                } else {
                    Log.e(TAG, "NULL VALUE API")
                }
                Divider()
                Spacer(modifier = Modifier.height(8.dp))


                if (!isEmpty.value) {
                    LazyColumn(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        items(todos.Todos,
                        key = {
                            it.id!!
                        }) {
                            ItemScreen(modifier = Modifier.padding(8.dp), it, reload)

                        }
                    }
                }
            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(15.dp),
                onClick = { open_ScreenAdd.value = true }, shape = CircleShape, backgroundColor = icon_bc2,
            ) {
                Image(imageVector = Icons.Default.Add, contentDescription = "", colorFilter = ColorFilter.tint(
                    Color.White))
            }

            if (isEmpty.value){

                Text(text = "لیست شما خالی است عزیزم", fontSize = 14.sp, fontFamily = iran, color = Color.White,
                    modifier = Modifier
                        .padding(start = 7.dp)
                        .align(Alignment.Center))

            }

            if (open_ScreenAdd.value){
                Dialog(onDismissRequest = { open_ScreenAdd.value = false}) {
                    AddTodo_Screen(openDialogCustom = open_ScreenAdd, last_id = last_id.value)
                }
            }else{
            LaunchedEffect(true) {
                mainViewModel.getTodos()
            }
        }

            if (reload.value){
                LaunchedEffect(true) {
                    mainViewModel.getTodos()
                }
                reload.value = false
            }


        }
    }

    


}