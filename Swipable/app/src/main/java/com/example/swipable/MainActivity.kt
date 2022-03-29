package com.example.swipable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipable.ui.theme.SwipableTheme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipableTheme {

                val archive = SwipeAction(
                    onSwipe = {
                        Log.d("Main Activity", "Archive")
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            painter = painterResource(id = R.drawable.archive),
                            contentDescription =null,
                            tint = Color.White
                        )
                    },
                    background = Color.Green,
                )

                val email = SwipeAction(
                    onSwipe = {
                        Log.d("Main Activity", "email")
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            painter = painterResource(id = R.drawable.email),
                            contentDescription =null,
                            tint = Color.White
                        )
                    },
                    background = Color.Blue,
                )
                
                SwipeableActionsBox(
                    swipeThreshold = 50.dp,
                    startActions = listOf(archive),
                    endActions = listOf(email)) {
                    Row(
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .padding(horizontal = 16.dp)
                            .padding(vertical = 8.dp),
                        ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .background(MaterialTheme.colors.primary)
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.padding(16.dp))

                        Column(modifier = Modifier.weight(7f)) {
                            Text(
                                text = "Title",
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Some description",
                                style = MaterialTheme.typography.body1
                            )
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
    SwipableTheme {
        Greeting("Android")
    }
}