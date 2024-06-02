package com.example.bitmap_resize.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.example.bitmap_resize.domain.repository.BitmapRepository


class BitmapRepositoryImpl(
    private val context : Context
) : BitmapRepository {

    override fun convertUriToBitmap(uri: Uri): Bitmap {
        TODO("Not yet implemented")
    }

}




