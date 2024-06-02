package com.example.bitmap_resize

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.bitmap_resize.presentation.nvgraph.NavGraph
import com.example.bitmap_resize.presentation.nvgraph.Route
import com.example.bitmap_resize.ui.theme.BitmapResizeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            BitmapResizeTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    startDestination = Route.HomeScreen
                )
            }
        }
    }

}