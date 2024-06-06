package com.example.bitmap_resize.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.example.bitmap_resize.domain.repository.CustomSizeRepository


class CustomSizeRepositoryImpl(
    private val context: Context
) : CustomSizeRepository {

    override fun convertUriToBitmap(uri: Uri): Bitmap? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri).use { inputStream ->
                val bitmap = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()
                bitmap
            }
            inputStream
        } catch (e: Exception) {
            null
        }
    }

    override fun changeBitmapHeightAndWidth(bitmap: Bitmap, height: Int, width: Int): Bitmap? {
        return try {
            val bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)
            bitmap
        } catch (e: Exception) {
            null
        }
    }

}




