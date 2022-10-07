package com.example.chessengineuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chessengineuk.ui.theme.ChessEngineUKTheme

// Chess Engine - UK Academy Task
// Mateusz Hermanowicz - 2022

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessEngineUKTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Chess Engine")
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChessEngineUKTheme {
        Greeting("Chess Engine")
    }
}