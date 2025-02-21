package com.pct.teamscorerev5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pct.teamscorerev5.ui.screens.coursedetail.CourseDetailScreen
import com.pct.teamscorerev5.ui.screens.courses.CoursesScreen
import com.pct.teamscorerev5.ui.screens.playersetup.PlayersScreen
import com.pct.teamscorerev5.ui.screens.scorecard.ScoreCardScreen
import com.pct.teamscorerev5.ui.screens.summary.SummaryScreen
import kotlinx.serialization.Serializable
import androidx.navigation.compose.rememberNavController as rememberNavController1


@Composable
fun MyNav(){
    val navController = rememberNavController1()
    NavHost(
        navController = navController,
        startDestination = Summary
    ) {
        composable<Summary>{
            SummaryScreen(navController)
        }
        composable<Courses>{
            CoursesScreen(navController)
        }
        composable<Detail>{
            CourseDetailScreen(navController)
        }
        composable<Player>{
            PlayersScreen(navController)
        }
        composable<ScoreCard>{
            ScoreCardScreen(navController)
        }


    }
}

@Serializable
object Summary

@Serializable
object Courses

@Serializable
object Detail

@Serializable
object Player

@Serializable
object ScoreCard


