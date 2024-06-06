package com.example.bitmap_resize.presentation.customsize

import android.net.Uri


sealed interface CustomSizeEvent{

    data class OnChoose(
        val uri : Uri
    ): CustomSizeEvent
    object OnConvert : CustomSizeEvent



}