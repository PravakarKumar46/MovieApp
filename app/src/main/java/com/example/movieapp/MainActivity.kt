package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MyContainer(content: @Composable () -> Unit) {
    MovieAppTheme {
        content()
    }
}

@Composable
fun MainContent() {

    Surface(color = MaterialTheme.colorScheme.background) {

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyContainer {
        MainContent()
    }
}