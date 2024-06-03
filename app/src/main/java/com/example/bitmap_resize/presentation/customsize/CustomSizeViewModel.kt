package com.example.bitmap_resize.presentation.customsize

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.example.bitmap_resize.domain.repository.BitmapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class CustomSizeViewModel @Inject constructor(
    private val bitmapRepository: BitmapRepository
) : ViewModel() {


    private val _bitmap = MutableStateFlow<Bitmap?>(null)
    val bitmap = _bitmap.asStateFlow()


    fun onEvent(event: CustomSizeEvent) {
        when (event) {
            is CustomSizeEvent.OnChoose -> {
                val bitmap = bitmapRepository.convertUriToBitmap(event.uri)
                _bitmap.update { bitmap }
            }

            CustomSizeEvent.OnConvert -> TODO()
        }

    }

    fun updateBitmap(bitmap: Bitmap?) {
        _bitmap.value = bitmap
    }


}