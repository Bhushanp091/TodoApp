package com.example.todoapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topappbar() {


    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    TopAppBar(

        title = { Text(text = "Task", color = Color.White) },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(3, 3, 3),),

        navigationIcon = {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = Color(210,36,85,255)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(210,36,85,255)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = Color(210,36,85,255)
                )
            }
        },
        scrollBehavior = scrollBehavior,


        )
}


data class bottomNavigationBar(
    val name:String,
    val selectedItem: ImageVector,
    val unselectedItem: ImageVector,
    val route:String,
    val color:Color
)

@Composable
fun Bottomappbar(){

    var selectedindex by rememberSaveable{ mutableStateOf(0) }
    val items = listOf(
        bottomNavigationBar(
            name = "Home",
            selectedItem = Icons.Filled.Home,
            unselectedItem = Icons.Outlined.Home,
            route= "home",
            color =  Color(210,36,85,255)
        ),
        bottomNavigationBar(
            name = "Task",
            selectedItem = Icons.Filled.CheckCircle,
            unselectedItem = Icons.Outlined.CheckCircle,
            route = "task",
            color =  Color(210,36,85,255)
        ),
        bottomNavigationBar(
            name = "Habit",
            selectedItem = Icons.Filled.List,
            unselectedItem = Icons.Outlined.List,
            route = "habit",
            color =  Color(210,36,85,255)
        ),
        bottomNavigationBar(
            name = "Settings",
            selectedItem = Icons.Filled.Settings,
            unselectedItem = Icons.Outlined.Settings,
            route ="",
            color =  Color(210,36,85,255)
        )
    )




    NavigationBar (
        contentColor = Color.Red,
        containerColor = Color(27,27,27)
    ){
        items.forEachIndexed { index, items ->
            NavigationBarItem(

                selected = selectedindex == index,//boolean
                onClick = {
                    selectedindex = index
                }

                ,
                label = { Text(text = items.name, color = Color.LightGray) },
                icon = {

                    Column {
                        Icon(
                            imageVector = if (selectedindex == index) {
                                items.selectedItem
                            } else items.unselectedItem,
                            contentDescription = items.name,
                            tint = if(selectedindex==index){
                                items.color
                            }else Color.LightGray,

                            )

                    }

                },
            )
        }
    }
}