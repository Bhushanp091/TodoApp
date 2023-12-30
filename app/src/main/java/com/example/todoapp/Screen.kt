package com.example.todoapp

sealed class Screen(val route:String) {
    object HomeScreen:Screen(route = "homescreen")
    object AddTodoScreen:Screen(route = "addtodoscreen")
    object ShowTodoScreen:Screen(route = "showTodoscreen")

}