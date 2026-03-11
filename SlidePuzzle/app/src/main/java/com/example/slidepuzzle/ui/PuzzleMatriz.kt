package com.example.slidepuzzle.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PuzzleMatriz(
    tablero: List<Int>,
    onClick: (Int) -> Unit
) {

    Column {

        for (fila in 0 until 3) {

            Row {

                for (col in 0 until 3) {

                    val index = fila * 3 + col
                    val valor = tablero[index]

                    Button(
                        onClick = { onClick(index) },
                        modifier = Modifier
                            .size(90.dp)
                            .padding(4.dp)
                    ) {

                        if (valor != 0)
                            Text(valor.toString())
                        else
                            Text("")

                    }
                }
            }
        }
    }
}