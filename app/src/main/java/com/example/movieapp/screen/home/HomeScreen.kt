package com.example.movieapp.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.movie.Movie
import com.example.movieapp.movie.getMovies
import com.example.movieapp.navigation.MovieScreen
import com.example.movieapp.widget.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    /**
     * Material Design layout.
     * Scaffold implements the basic material design visual layout structure.
     * This component provides API to put together several material components to construct your screen,
     * by ensuring proper layout strategy for them and collecting necessary data
     * so these components will work together correctly.
     */
    Scaffold(
        // below line we are
        // creating a top bar.
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Transparent),
                // in below line we are
                // adding title to our top bar.
                title = {
                    // inside title we are
                    // adding text to our toolbar.
                    Text(
                        text = "Movies"
                    )
                }
            )
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue)
        ) { MainContent(navController = navController) }
    }

}

@Composable
fun MainContent(
    movieList: List<Movie> = getMovies(),
    navController: NavController
) {

    Column(modifier = Modifier.padding(12.dp)) {

        LazyColumn {

            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreen.DetailsScreen.name + "/$movie")
                }
            }

        }

    }

}
