package com.example.swipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.swipe.ui.theme.SwipeTheme
import com.example.swipe.ui.theme.Whisper
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeTheme {
                val uiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colorScheme == darkColorScheme()

                LaunchedEffect(Unit) {
                    WindowCompat.setDecorFitsSystemWindows(window, false)
                    uiController.setSystemBarsColor(Color.Transparent, darkIcons = true)
                    uiController.setNavigationBarColor(Color.Transparent)
                }
                val colors = lightColorScheme().copy(
                    background = Color.Whisper,
                    surface = Color.Whisper,
                )
                MaterialTheme(colors) {
                    Scaffold() {
                        Card(onClick = {}, modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)) {
                            Text("Hello World")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwipeTheme {
        Greeting("Android")
    }
}