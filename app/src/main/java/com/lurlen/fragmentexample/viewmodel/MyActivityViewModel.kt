package com.lurlen.fragmentexample.viewmodel

import androidx.lifecycle.ViewModel

class MyActivityViewModel : ViewModel() {

    var nameFirstFragment: String = ""
    var addressFirstFragment: String = ""

    var saludoSecondFragment: String = "Saludo por defecto del Second Fragment"

    var continuarThirdFragment: String = "Continuar por aquí"

    fun guardarTemporalmenteDataParaFirstFragment(name: String, address: String) {
        nameFirstFragment = name
        addressFirstFragment = address
    }

    private fun numeroAleatorio(): Int {
        return (0 until 10).random()
    }

    fun sumaNumerosAleatorios(): String {
        val num1 = numeroAleatorio()
        val num2 = numeroAleatorio()
        val suma = num1 + num2
        return "La suma de $num1 + $num2, es igual a $suma"
    }

}