package com.example.todoapp.presentation

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.Screen
import com.example.todoapp.TodoViewmodel
import com.example.todoapp.ui.theme.BlueTheme
import com.example.todoapp.ui.theme.DarkBackground
import com.example.todoapp.ui.theme.LittleDarkBackround
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController,viewmodel:TodoViewmodel){
    Scaffold(
        topBar = { Topappbar()},
        bottomBar = { Bottomappbar()},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewmodel.getTodo=""
                    viewmodel.getDescription=""
                    navController.navigate(Screen.AddTodoScreen.route)},
                modifier = Modifier.padding( 5.dp),
                contentColor = Color.White,
                containerColor = BlueTheme
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null )
            }
        },

    ) {paddingValue->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .background(DarkBackground)
        ){
            item { ShowDatesRow()}
            itemsIndexed(
                items=viewmodel.todoItem,
                key = { _, item ->
                    item.hashCode()
                }
            ){ index, item->
                var show by remember { mutableStateOf(true) }
                val state = rememberDismissState(
                    confirmValueChange = {
                        if (it == DismissValue.DismissedToStart) {
                            show = false
                            viewmodel.todoItem=viewmodel.todoItem-item
                        }
                        true

                    }
                )
                AnimatedVisibility(
                    show,exit = fadeOut(spring())
                ){
                SwipeToDismiss(
                    state = state,
                    background = {
                        val color = when (state.dismissDirection) {
                            DismissDirection.StartToEnd -> Color.Transparent
                            DismissDirection.EndToStart -> Color.Red
                            null -> Color.Transparent
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .height(60.dp)
                                .background(color = color)
                                .padding(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = Color.White,
                                modifier = Modifier.align(Alignment.CenterEnd)
                            )
                        }
                    },
                    dismissContent = {
                         ShowTodos(viewmodel = viewmodel, items =item )
                    },
                    directions = setOf(DismissDirection.EndToStart)
                )}
                LaunchedEffect(show) {
                    if (!show) {
                        delay(800)
                    }
                }
            }



        }
    }
}


@Composable
fun ShowDatesRow(){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)

    ){
        items(50){
                item->
            ElevatedCard(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .padding(4.dp)
                    .width(50.dp)
                    .height(65.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LittleDarkBackround
                ),

                ) {
                Box(modifier = Modifier.
                fillMaxWidth()

                ) {
                    Text(text = "Sat", color = Color.DarkGray ,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(start  = 12.dp, top = 1.dp, end = 0.dp, bottom = 5.dp),)
                }

                ElevatedCard (
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .widthIn(min = 50.dp)
                        .height(50.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = LittleDarkBackround
                    ),

                    ){
                    Box(modifier = Modifier.
                    fillMaxWidth()
                    ) {
                        Text(text = "$item", color = Color.LightGray ,
                            modifier = Modifier
                                .padding(horizontal = 14.dp, vertical = 6.dp)
                                .background(LittleDarkBackround),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

