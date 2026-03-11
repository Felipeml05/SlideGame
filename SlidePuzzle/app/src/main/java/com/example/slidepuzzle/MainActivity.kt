package com.example.slidepuzzle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.slidepuzzle.ui.PuzzlePantalla


class MainActivity : ComponentActivity() {

    private val viewModel: PuzzleLogica by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PuzzlePantalla(viewModel)
        }
    }
}