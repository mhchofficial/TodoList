package com.akatsuki.todolist.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.akatsuki.todolist.data.local.model.TodosModel
import com.akatsuki.todolist.ui.screens.main.MainViewModel
import com.akatsuki.todolist.ui.theme.icon_bc
import com.akatsuki.todolist.ui.theme.icon_bc2
import com.akatsuki.todolist.ui.theme.iran
import com.akatsuki.todolist.ui.theme.item
import kotlinx.coroutines.delay

@Composable
fun ItemScreen(modifier: Modifier, data: TodosModel, reload: MutableState<Boolean>,
mainViewModel: MainViewModel = hiltViewModel()){
    val check = remember {
        mutableStateOf(false)
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

        Row(modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            //.height(100.dp)
            //.padding(4.dp)
            .background(item, RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            //Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(data.sub, color = Color.White, fontFamily = iran, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(2f))
            Checkbox(checked = check.value, onCheckedChange = {check.value = it}, modifier = Modifier.size(50.dp), colors = myCheckBoxColors())

        }
    }

    if (check.value){
        LaunchedEffect(true){
            mainViewModel.deleteTodoById(data.id!!)

        }
        when(mainViewModel.stateDelte.value){
            true -> {
                reload.value = true
            }
            else -> {}
        }


    }
}

@Composable
fun myCheckBoxColors(): CheckboxColors {
    return CheckboxDefaults.colors(
        checkedColor = icon_bc,
        uncheckedColor = icon_bc2
    )
}