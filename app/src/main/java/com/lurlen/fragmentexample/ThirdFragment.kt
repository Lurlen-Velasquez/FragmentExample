package com.lurlen.fragmentexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.lurlen.fragmentexample.viewmodel.MyASDFViewModel
import com.lurlen.fragmentexample.viewmodel.MyActivityViewModel
import kotlin.math.log


class ThirdFragment : Fragment() {

    private val viewModel : MyActivityViewModel by activityViewModels()
    private val MyASDFViewModel : MyASDFViewModel by viewModels()

    private var continuar: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            continuar = it.getString(CONTINUAR)
//
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        continuar = viewModel.continuarThirdFragment

        val textResultadoSuma = view.findViewById<TextView>(R.id.tvResultadoSuma)
        val buttonSuma = view.findViewById<Button>(R.id.btnSumaAleatoria)
        val textContinuar = view.findViewById<TextView>(R.id.myTextContinuar)
        val textResultadoMultiply = view.findViewById<TextView>(R.id.tvResultadoMultiply)
        val buttonMultiply = view.findViewById<Button>(R.id.btnMultiplyAleatoria)
        textContinuar.text = continuar

        textResultadoSuma.text = viewModel.sumaNumerosAleatorios()
        textResultadoMultiply.text = MyASDFViewModel.multiplyNumerosAleatorios()

        buttonSuma.setOnClickListener {
            textResultadoSuma.text = viewModel.sumaNumerosAleatorios()
        }
        buttonMultiply.setOnClickListener {
            textResultadoMultiply.text = MyASDFViewModel.multiplyNumerosAleatorios()
        }

        Log.d("len_v", "param1 = $continuar")
    }

    companion object {
        const val CONTINUAR = "param1"

    }
}