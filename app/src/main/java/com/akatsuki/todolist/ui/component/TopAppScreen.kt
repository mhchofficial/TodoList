package com.akatsuki.todolist.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akatsuki.todolist.data.remote.models.ApiResponse
import com.akatsuki.todolist.ui.theme.bc
import com.akatsuki.todolist.ui.theme.iran
import com.akatsuki.todolist.ui.theme.vasir


@Composable
fun TopAppScreen(modifier: Modifier ,data : ApiResponse){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                //.height(200.dp)
                .wrapContentHeight()
                .background(bc),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = data.author, fontSize = 16.sp, fontFamily = vasir, color = Color.White,
                modifier = Modifier.padding(start = 7.dp)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = data.message,
                fontSize = 15.sp,
                fontFamily = iran,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp, bottom = 7.dp)
            )


        }
    }
}