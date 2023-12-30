package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.presentation.AddTodo
import com.example.todoapp.presentation.HomeView


@Composable
fun Navigation(viewmodel: TodoViewmodel){

    val NavController = rememberNavController()

    NavHost(navController = NavController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeView(navController = NavController,viewmodel = viewmodel)
        }

        composable(Screen.AddTodoScreen.route){
            AddTodo(navController = NavController, viewmodel = viewmodel)
        }
    }
}