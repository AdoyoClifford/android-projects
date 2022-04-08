package com.example.animations.ui.screen

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.animations.R

@Composable
fun LoginScreen(){
    BackGroundImage()
}

@Composable
fun BackGroundImage(){
    Box(contentAlignment = Alignment.TopCenter) {
        Image(painter = painterResource(id = R.drawable.toon), contentDescription = "Log in Page" ,
        modifier = Modifier.fillMaxSize()
            .size(2000.dp),
        contentScale = FillBounds)
        
    }
}