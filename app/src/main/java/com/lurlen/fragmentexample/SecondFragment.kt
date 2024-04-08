package com.lurlen.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.lurlen.fragmentexample.viewmodel.MyActivityViewModel
import com.lurlen.fragmentexample.viewmodel.MyASDFViewModel


class SecondFragment : Fragment() {


    private val viewModel: MyActivityViewModel by activityViewModels()
    private val viewModelMio : MyASDFViewModel by viewModels()

    private var saludo: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        saludo = requireArguments().getString(SALUDO)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textSaludo = view.findViewById<TextView>(R.id.myText)
        saludo = viewModel.saludoSecondFragment
        textSaludo.text = saludo
    }


    companion object {

        const val SALUDO = "param1"
    }
}