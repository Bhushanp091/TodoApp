package com.example.todoapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class todoitems(
    var todoName:String,
    val description:String,
    var isChecked:Boolean
)
class TodoViewmodel:ViewModel() {



    var getTodo by mutableStateOf("")
    var getDescription by mutableStateOf("")
    var todoItem by mutableStateOf(listOf<todoitems>())
    var isChecked by mutableStateOf(false)


}