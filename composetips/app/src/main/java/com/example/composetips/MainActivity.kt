package com.example.composetips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cable
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetips.ui.theme.ComposeTipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTipsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConversationItem(
                        title = "John Doe",
                        snippet = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        timestamp = "12:00",
                        profilePainters = listOf(


                }
            }
        }
    }
}

@Composable
fun HorizontalArrangement() {
    Row(
      horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
      verticalAlignment = Alignment.Bottom
    ) {
        Icon(Icons.Rounded.Menu, contentDescription = "Menu",
            modifier = Modifier.weight(1f))
        Icon(Icons.Rounded.Phone, contentDescription = "phone", modifier = Modifier.weight(1f))
        Icon(Icons.Rounded.Tab, contentDescription = "Tab",modifier = Modifier.weight(1f))
        Icon(Icons.Rounded.Cable, contentDescription = "Cable", modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTipsTheme {
        HorizontalArrangement()
    }
}
@Composable
fun ConversationItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    snippet: String,
    unread: Boolean = false,
    timestamp: String,
    profilePainters: List<Painter>,
) {
    val typeAlpha = if (unread) {
        ContentAlpha.high
    } else {
        ContentAlpha.medium
    }
    Surface(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onClick()
            },
        color = MaterialTheme.colors.background,
    ) {
        Row(
            Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            /*ConversationPhoto(
                painters = profilePainters
            )*/
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row {
                    Text(
                        title, modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(Modifier.width(10.dp))
                    Text(
                        timestamp,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.alpha(typeAlpha)
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    snippet,
                    modifier = Modifier.alpha(typeAlpha),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}