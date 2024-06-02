package com.example.bitmap_resize.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bitmap_resize.presentation.ResizeBitmapScreen
import com.example.bitmap_resize.presentation.HomeScreen


@Composable
fun NavGraph(
    navController : NavHostController = rememberNavController(),
    startDestination : Route = Route.HomeScreen
){

    NavHost(
        navController = navController,
        startDestination = startDestination
        )
    {
        composable<Route.HomeScreen> {
            HomeScreen(
                onClick = {
                    navController.navigate(Route.ResizeBitmap)
                }
            )
        }
        composable<Route.ResizeBitmap> {
            ResizeBitmapScreen()
        }
    }


}