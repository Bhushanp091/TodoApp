package com.example.todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.TodoViewmodel
import com.example.todoapp.todoitems
import com.example.todoapp.ui.theme.BlueTheme
import com.example.todoapp.ui.theme.DarkBackground
import com.example.todoapp.ui.theme.LittleDarkBackround

@Composable
fun ShowTodos(viewmodel: TodoViewmodel, items: todoitems){

    ElevatedCard (
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(4.dp)
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = LittleDarkBackround
        ),
    ){
        Row (
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Box(

                ){
                    Icon(imageVector =Icons.Default.Check ,
                        contentDescription = null,
                        tint = DarkBackground,
                        modifier = Modifier
                            .size(40.dp)
                            .background(BlueTheme, shape = RoundedCornerShape(10.dp))
                    )
                }
                Column {
                    Text(
                        text = items.todoName,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        textAlign = TextAlign.Center,

                        )
                    Row {
                        Text(
                            text = items.description,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontSize = 10.sp,
                            color = BlueTheme,
                            textAlign = TextAlign.Center,

                            )
                        Text(
                            text = "$",
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontSize = 10.sp,
                            color = BlueTheme,
                            textAlign = TextAlign.Center,

                            )
                    }

                }



            }
            CircularCheckbox(items=items)

        }
    }


}

@Composable
fun CircularCheckbox(
    modifier: Modifier = Modifier,
    items: todoitems
) {

    var isCheckedState by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .size(45.dp)
            .padding(8.dp)
            .background(
                color = if (isCheckedState) BlueTheme else Color.DarkGray,
                shape = CircleShape
            )
            .clickable {
                isCheckedState = !isCheckedState
                items.isChecked = !items.isChecked
            },
        contentAlignment = Alignment.Center
    ) {
        if (isCheckedState) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}