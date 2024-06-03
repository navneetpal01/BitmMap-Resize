package com.example.bitmap_resize.domain.repository

import android.graphics.Bitmap
import android.net.Uri


interface BitmapRepository{


    fun convertUriToBitmap(uri : Uri) : Bitmap?



}