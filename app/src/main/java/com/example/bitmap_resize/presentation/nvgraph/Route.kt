package com.example.bitmap_resize.presentation.nvgraph

import kotlinx.serialization.Serializable


@Serializable
sealed class Route{

    @Serializable
    object HomeScreen : Route()

    @Serializable
    object ResizeBitmap : Route()

}