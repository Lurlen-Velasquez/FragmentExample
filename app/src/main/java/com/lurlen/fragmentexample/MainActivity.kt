package com.lurlen.fragmentexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.lurlen.fragmentexample.FirstFragment.Companion.ADDRESS_BUNDLE
import com.lurlen.fragmentexample.FirstFragment.Companion.NAME_BUNDLE
import com.lurlen.fragmentexample.databinding.ActivityFragmentexampleBinding
import com.lurlen.fragmentexample.viewmodel.MyActivityViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentexampleBinding
    private val viewModel: MyActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentexampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val bundle = bundleOf(
                NAME_BUNDLE to "Lurlen",
                ADDRESS_BUNDLE to "Casa 123"
            )

            viewModel.guardarTemporalmenteDataParaFirstFragment(
                name = "Lurlen desde viewModel",
                address = "Casa 123"
            )

            // para agregar el fragment mediante codigo
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragmentContainer, args = bundle)
            }


            viewModel.saludoSecondFragment = "Hello People"
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(R.id.fragmentContainer2)
            }

//            viewModel.continuarThirdFragment = "Continuar por aquí"
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ThirdFragment>(R.id.fragmentContainer3)
            }
        }
    }
}