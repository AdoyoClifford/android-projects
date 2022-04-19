package com.example.messagelist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messagelist.ui.theme.MessageListTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Message1()
                }
            }
        }
    }
}

private lateinit var messageList: ArrayList<MessageData>

@Composable
fun TopAppBarMessage(
    context: Context = LocalContext.current.applicationContext
) {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Messages",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 4.dp,
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Navigation Icon Clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ){

    }
}

@Composable
fun Message1(){
    var listPrepared by remember { mutableStateOf(false) }
    //TopAppBarMessage()
    if (listPrepared) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(messageList) {itemObject ->
                MessagesItemStyle(item = itemObject)
            }
        }
    }

    LaunchedEffect(Unit ) {
        withContext(Dispatchers.Default) {
            prepareMessageList()
            listPrepared = true
        }
    }
}

@Composable
fun MessagesItemStyle(
    item: MessageData,
    context: Context = LocalContext.current.applicationContext) {
    Box (
        modifier = Modifier
            .clickable(onClick = {
                Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
            })
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(56.dp),
                painter = painterResource(id = item.image),
                contentDescription = item.name
            )

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(item.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    )

                    Text(text = item.time,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                            fontSize = 14.sp,
                            color = Color.Black
                        )

                        )
                    Text(modifier = Modifier.padding(top = 2.dp),
                        text = item.message,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }

}

private fun prepareMessageList(){
    messageList = ArrayList()
    messageList.add(
        MessageData(
            R.drawable.ann,
            "Ann",
            "Cool we meet tomorrow",
            "12:00"
        )
    )
    messageList.add(
        MessageData(
            R.drawable.emily,
            "Emily",
            "I'm going to the beach",
            "12:00"
        )
    )
    messageList.add(
        MessageData(
            R.drawable.teddy,
            "Teddy",
            "I'm going to the beach",
            "12:00"
        )
    )
    messageList.add(
        MessageData(
            R.drawable.maestro,
            "Maestro",
            "I'm going to the beach",
            "12:00"
        )
    )
}

data class MessageData(
   val image: Int,
   val name: String,
   val message: String,
   val time: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MessageListTheme {
        TopAppBarMessage()
    }
}