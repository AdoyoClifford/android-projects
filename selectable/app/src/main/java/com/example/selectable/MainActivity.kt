package com.example.selectable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selectable.ui.theme.SelectableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelectableTheme {
                var selected by remember {
                  mutableStateOf(false)
                }
                var selected2 by remember {
                    mutableStateOf(false)
                }
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(88.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                        ){
                    SelectableItem(
                        selected = selected,
                        title = "Lorem Ipsum",
                        onClick = {
                            selected = !selected
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    SelectableItem(
                        selected = selected2,
                        title = "With WhatsApp, you'll get fast, simple, secure messaging and calling for free*, available on phones all over the world.",
                        onClick = {
                            selected2 = !selected2
                        }
                    )
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
    SelectableTheme {
        Greeting("Android")
    }
}