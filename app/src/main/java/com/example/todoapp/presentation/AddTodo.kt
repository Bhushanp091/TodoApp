package com.example.todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.TodoViewmodel
import com.example.todoapp.todoitems
import com.example.todoapp.ui.theme.BlueTheme
import com.example.todoapp.ui.theme.DarkBackground

@Composable
fun AddTodo(navController: NavController,
            viewmodel: TodoViewmodel){
    Box (
        modifier = Modifier
            .background(DarkBackground)
            .fillMaxSize()
    ){
        Column {
            Textfield1(viewmodel = viewmodel)
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Textfield2(viewmodel = viewmodel)
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Button(onClick = {
                var add = todoitems(todoName = viewmodel.getTodo
                , description = viewmodel.getDescription,isChecked = false)
                viewmodel.todoItem=viewmodel.todoItem+add
                navController.popBackStack()
            }) {
                Text(text = "Save")
            }
        }

    }

}

@Composable
fun Textfield1(viewmodel: TodoViewmodel){
    OutlinedTextField(
        value = viewmodel.getTodo ,
        singleLine = true,
        textStyle = TextStyle(fontSize = 12.sp) ,
        onValueChange = {viewmodel.getTodo=it},
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = 4.dp, vertical = 8.dp),
        shape = RoundedCornerShape(22.dp) ,
        label = { Text(text = "AddTodo", color = BlueTheme, fontSize = 12.sp) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BlueTheme,
            unfocusedBorderColor = BlueTheme
        ),

        )
}
@Composable
fun Textfield2(viewmodel: TodoViewmodel){
    OutlinedTextField(
        value = viewmodel.getDescription ,
        singleLine = true,
        textStyle = TextStyle(fontSize = 12.sp),
        onValueChange = {viewmodel.getDescription=it},
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = 4.dp, vertical = 8.dp),
        shape = RoundedCornerShape(22.dp) ,
        label = { Text(text = "Description", color = BlueTheme, fontSize = 12.sp) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BlueTheme,
            unfocusedBorderColor = BlueTheme
        ),

        )
}