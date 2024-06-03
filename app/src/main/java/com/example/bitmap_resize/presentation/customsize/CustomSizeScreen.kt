package com.example.bitmap_resize.presentation.customsize

import android.graphics.Bitmap
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSizeScreen(
    bitmapState : Bitmap?,
    event : (CustomSizeEvent) -> Unit
) {


    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri ->
        if (uri != null){
            event(CustomSizeEvent.OnChoose(uri))
        }else{
            Log.d("App", "User didn't selected any image")
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .padding(start = 5.dp, end = 10.dp),
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.scrim),
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.scrim),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                              imagePicker.launch("image/*")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp, top = 6.dp),
                    shape = RectangleShape
                )
                {
                    Text(
                        text = "Choose Image"
                    )
                }
                Button(
                    onClick = {
                        if (false) {
                            Log.d("pokemon", "CustomSizeScreen: ")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.3f)),
                    modifier = Modifier
                        .clickable(enabled = false) {

                        }
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp, vertical = 6.dp),
                    shape = RectangleShape
                )
                {
                    Text(
                        text = "Convert"
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(180.dp)
                    .background(MaterialTheme.colorScheme.inverseSurface),
                contentAlignment = Alignment.Center
            ){
                bitmapState?.let {bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit
                )

                }

            }
        }
    }


}