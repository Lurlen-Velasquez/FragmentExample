package com.lurlen.fragmentexample.viewmodel

import androidx.lifecycle.ViewModel

class MyASDFViewModel : ViewModel() {

    private fun numeroAleatorio(): Int {
        return (0 until 10).random()
    }

    fun multiplyNumerosAleatorios(): String {
        val num1 = numeroAleatorio()
        val num2 = numeroAleatorio()
        val multiply = num1 * num2
        return "La multiplicacion de $num1 X $num2, es igual a $multiply"
    }

}