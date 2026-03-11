package com.example.slidepuzzle

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.math.abs

class PuzzleLogica : ViewModel() {

    val tablero = mutableStateListOf<Int>()

    var movimientos = 0
    var metaMovimientos = 0

    var dificultad = ""

    init {
        reiniciarJuego()
    }

    fun reiniciarJuego() {

        tablero.clear()
        tablero.addAll(List(9) { it })
        var auxDificultad = 0
        verificarTablero()
        movimientos = 0
        auxDificultad = verificarDificultad()
        metaMovimientos = auxDificultad * 3
        if (auxDificultad <= 22){
            dificultad = "Dificil"
            if (auxDificultad <= 16) {
                dificultad = "Medio"
                if (auxDificultad <= 8) {
                    dificultad = "Facil"
                }
            }
        }
    }

    fun mover(pos: Int): Boolean {

        val vacio = tablero.indexOf(0)
        val fila1 = pos / 3
        val col1 = pos % 3
        val fila2 = vacio / 3
        val col2 = vacio % 3
        val esAdyacente =
            (fila1 == fila2 && abs(col1 - col2) == 1) ||
                    (col1 == col2 && abs(fila1 - fila2) == 1)
        if (!esAdyacente) return false
        tablero[vacio] = tablero[pos]
        tablero[pos] = 0
        movimientos++
        return true
    }

    fun estaResuelto(): Boolean {
        for (i in 0 until 8) {
            if (tablero[i] != i + 1) return false
        }
        return tablero[8] == 0
    }

    fun evaluarResultado(): String {
        return when {
            movimientos == metaMovimientos -> "¡Perfecto!, igualaslaste la meta"
            movimientos < metaMovimientos -> "Haz superado las espectativas acabaste en menos movimientos"
            movimientos <= metaMovimientos +5 -> "Estuviste muy cerca"
            else -> "Resuelto pero con muchos movimientos"
        }
    }

    fun verificarTablero() : Boolean {
        var inversiones: Int
        do{
            inversiones=0
            tablero.shuffle()
            for(i in 0..8){
                for (x in 0..8){
                    if (i<x){
                        if (tablero[i] != 0 && tablero[x] != 0 && tablero[i]>tablero[x]){
                            inversiones++
                        }
                    }
                }
            }
        }while(inversiones % 2 != 0)
        return true
    }

    fun verificarDificultad(): Int {
        var distancia = 0
        for (i in 0..8) {
            val valor = tablero[i]
            if (valor != 0) {
                val filaActual = i / 3
                val colActual = i % 3
                val filaCorrecta = (valor - 1) / 3
                val colCorrecta = (valor - 1) % 3
                distancia += abs(filaActual - filaCorrecta) +
                        abs(colActual - colCorrecta)
            }
        }
        return distancia
    }

}