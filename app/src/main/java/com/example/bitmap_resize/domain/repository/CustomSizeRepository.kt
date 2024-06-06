package com.example.bitmap_resize.domain.repository

import android.graphics.Bitmap
import android.net.Uri


interface CustomSizeRepository {


    fun convertUriToBitmap(uri: Uri): Bitmap?
    fun changeBitmapHeightAndWidth(bitmap: Bitmap, height: Int, width: Int): Bitmap?


}