package com.example.movies.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies.model.getMovies
import com.example.movies.widget.MovieRow

@ExperimentalAnimationApi
@Composable
fun DetailsScreen(
    navController: NavController,
    movieID: String
    ){
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieID
    }
    Scaffold(
        topBar = {
    TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
        Row(horizontalArrangement = Arrangement.Start) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
            modifier = Modifier.clickable {
                navController.popBackStack()
            })
            Spacer(modifier = Modifier.width(100.dp))

            Text(text = "detail")
        }
    }
    }
    ) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
                MovieRow()
            }
        }

    }
}