package com.example.bitmap_resize.data.repository

import android.content.Context
import android.graphics.Bitmap
import com.example.bitmap_resize.domain.repository.MediaStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MediaStoreRepositoryImpl(
    private val context: Context
): MediaStoreRepository{
    override suspend fun saveBitmap(bitmap: Bitmap) {
        return withContext(Dispatchers.IO){
            val resolver = context.contentResolver

        }
    }


}