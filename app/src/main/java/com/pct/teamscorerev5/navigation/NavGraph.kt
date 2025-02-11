package com.pct.teamscorerev5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import androidx.navigation.compose.rememberNavController as rememberNavController1


@Composable
fun MyNav(){
    val navController = rememberNavController1()
    NavHost(navController = navController, startDestination = Home ) {
        composable<Home>{
            HomeScreen(navController)
        }

        composable<Detail> {
            val args = it.toRoute<Detail>()
            DetailScreen(name = args.name, age = args.age)
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    TODO("Not yet implemented")
}


@Serializable
object Home

@Serializable
data class Detail(
    val name : String?,
    val age : Int
)