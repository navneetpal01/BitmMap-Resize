package com.example.bitmap_resize.presentation.nvgraph

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bitmap_resize.presentation.HomeScreen
import com.example.bitmap_resize.presentation.customsize.CustomSizeScreen
import com.example.bitmap_resize.presentation.customsize.CustomSizeViewModel


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: Route = Route.HomeScreen
) {

    val customSizeViewModel = viewModel<CustomSizeViewModel>()

    NavHost(
        navController = navController,
        startDestination = startDestination
    )
    {
        composable<Route.HomeScreen> {
            HomeScreen(
                onClick = {
                    navController.navigate(Route.CustomSize)
                }
            )
        }
        composable<Route.CustomSize> {
            val bitmapState = customSizeViewModel.bitmap.collectAsState().value
            BackHandler {
                customSizeViewModel.updateBitmap(null)
                navController.popBackStack()
            }
            CustomSizeScreen(
                bitmapState = bitmapState,
                event = customSizeViewModel::onEvent,
                onArrowClick = {
                    navController.popBackStack()
                    customSizeViewModel.updateBitmap(null)
                },
                state = customSizeViewModel.state
            )
        }
    }


}