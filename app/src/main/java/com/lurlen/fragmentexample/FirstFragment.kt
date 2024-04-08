package com.lurlen.fragmentexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.lurlen.fragmentexample.viewmodel.MyActivityViewModel


class FirstFragment : Fragment() {

    private val viewModel: MyActivityViewModel by activityViewModels()

    private var name: String? = null
    private var address: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        arguments?.let { //con esto le estamos diciendo que si hay algo guardado me lo puedes dar
////            name = it.getString(NAME_BUNDLE)
////            address = it.getString(ADDRESS_BUNDLE)
////        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = viewModel.nameFirstFragment
        address = viewModel.addressFirstFragment

        val button = view.findViewById<Button>(R.id.btnClick)

        button.setOnClickListener {
            Log.d("len_v", "name: $name")
            Log.d("len_v", "address: $address")
        }
    }

    companion object {

        const val NAME_BUNDLE = "name_bundle"
        const val ADDRESS_BUNDLE = "address_bundle"

    }
}