package com.example.movies.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies.model.Movie
import com.example.movies.model.getMovies
import com.example.movies.widget.MovieRow

@ExperimentalAnimationApi
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                Text(text = "Movies")
            }
        },
    ) {

    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent(
    navController: NavController,
    movielist:List<Movie> = getMovies()
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
//        LazyColumn{
//            items(items = movielist) {
//                MovieRow(movie = it) {
//                    navController.navigate(route = MoviesScreens.DetailsScreen.name + "/$movie")
//                }
//            }
//        }

    }

}