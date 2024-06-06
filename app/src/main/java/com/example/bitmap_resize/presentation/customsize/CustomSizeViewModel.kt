package com.example.bitmap_resize.presentation.customsize

import android.graphics.Bitmap
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bitmap_resize.domain.repository.CustomSizeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.time.Duration


@HiltViewModel
class CustomSizeViewModel @Inject constructor(
    private val customSizeRepository: CustomSizeRepository
) : ViewModel() {

    var state by mutableStateOf<CustomSizeState>(CustomSizeState())

    private val _bitmap = MutableStateFlow<Bitmap?>(null)
    val bitmap = _bitmap.asStateFlow()


    fun onEvent(event: CustomSizeEvent) {
        when (event) {
            is CustomSizeEvent.OnChoose -> {
                val bitmap = customSizeRepository.convertUriToBitmap(event.uri)
                _bitmap.update { bitmap }
            }

            CustomSizeEvent.OnConvert -> {
                if (_bitmap.value != null) {
                    val bitmap = customSizeRepository.changeBitmapHeightAndWidth(
                        _bitmap.value!!,
                        state.height,
                        state.width
                    )
                    _bitmap.update { bitmap }
                }
            }
        }

    }

    fun updateBitmap(bitmap: Bitmap?) {
        _bitmap.value = bitmap
    }


}