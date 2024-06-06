package com.example.bitmap_resize.domain.repository

import android.graphics.Bitmap


interface MediaStoreRepository{
   suspend fun saveBitmap(bitmap : Bitmap)
}