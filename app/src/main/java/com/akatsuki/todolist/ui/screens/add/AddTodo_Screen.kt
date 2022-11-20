package com.akatsuki.todolist.ui.screens.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akatsuki.todolist.R
import com.akatsuki.todolist.ui.component.EditText
import com.akatsuki.todolist.ui.screens.main.MainViewModel
import com.akatsuki.todolist.ui.theme.bc
import com.akatsuki.todolist.ui.theme.icon_bc2
import com.akatsuki.todolist.ui.theme.vasir


@Composable
fun AddTodo_Screen(modifier: Modifier = Modifier, openDialogCustom: MutableState<Boolean>, last_id: Int,
                   addViewModel: AddViewModel = hiltViewModel(),
                   mainViewModel: MainViewModel = hiltViewModel()
                   ){
    val subject = remember {
        mutableStateOf("")

    }
    val add_toList = remember {
        mutableStateOf(false)
    }






    LaunchedEffect(true) {
        mainViewModel.getTodos()
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

        Column(modifier = modifier
            .fillMaxWidth()
            .background(bc, shape = RoundedCornerShape(13.dp))
            .wrapContentHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                color = Color.White,
                text = "میخوای چیکار کنی؟",
                fontFamily = vasir,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            EditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                value = subject.value,
                onValueChange = {subject.value = it },
                label = "بنویس",
                draw = R.drawable.edit ,
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {add_toList.value = true
                             },modifier = Modifier
                .height(60.dp)
                .width(150.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .clip(shape = RoundedCornerShape(11.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = icon_bc2)

            ) {
                Text(text = "تمام", color = Color.White, fontSize = 16.sp, fontFamily = vasir)
            }
            Spacer(modifier = Modifier.height(30.dp))


        }
    }


    if (add_toList.value){
        val id = last_id + 1
        addViewModel.AddTodo(id, subject.value)
        openDialogCustom.value = false
        add_toList.value = false
    }
}