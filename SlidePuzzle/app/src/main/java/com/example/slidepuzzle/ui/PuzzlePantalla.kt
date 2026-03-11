package com.example.slidepuzzle.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.slidepuzzle.PuzzleLogica

@Composable
fun PuzzlePantalla(viewModel: PuzzleLogica) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Dificultad: ${viewModel.dificultad}")
        Text("Movimientos: ${viewModel.movimientos}")
        Text("Meta de Movimientos: ${viewModel.metaMovimientos}")

        Spacer(modifier = Modifier.height(20.dp))

        PuzzleMatriz(
            tablero = viewModel.tablero,
            onClick = { index ->
                viewModel.mover(index)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { viewModel.reiniciarJuego() }
        ) {
            Text("Reiniciar")
        }

        if (viewModel.estaResuelto()) {
            Text(viewModel.evaluarResultado())
        }
    }
}