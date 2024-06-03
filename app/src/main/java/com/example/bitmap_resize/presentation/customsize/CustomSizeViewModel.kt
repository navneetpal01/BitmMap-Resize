package com.example.bitmap_resize.presentation.customsize

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.example.bitmap_resize.domain.repository.BitmapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


@HiltViewModel
class CustomSizeViewModel(
    private val bitmapRepository: BitmapRepository
): ViewModel() {


    private val _bitmap = MutableStateFlow<Bitmap?>(null)
    val bitmap = _bitmap.asStateFlow()



    fun onEvent(event : CustomSizeEvent){
        when(event){
            is CustomSizeEvent.OnChoose -> {
                val bitmap = bitmapRepository.convertUriToBitmap(event.uri)
                _bitmap.
            }
            CustomSizeEvent.OnConvert -> TODO()
        }

    }


    private fun updateBitmap(bitmap: Bitmap) {
        _bitmap.update { bitmap }
    }





}