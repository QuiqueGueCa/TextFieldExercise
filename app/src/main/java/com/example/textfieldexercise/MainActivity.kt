package com.example.textfieldexercise

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.textfieldexercise.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etTop = binding.etTop
        val etBottom = binding.etBottom
        val tvTxtToShow = binding.tvTxtToShow
        val btnChecker = binding.btnChecker


        etTop.doAfterTextChanged {
            tvTxtToShow.text = etTop.text
        }

        etBottom.doAfterTextChanged {
            tvTxtToShow.text = etBottom.text
        }

        btnChecker.setOnClickListener {
            tvTxtToShow.text = checkingIfEquals(etTop.text.toString(), etBottom.text.toString())
        }

        quitingKeyboard()
    }


    private fun quitingKeyboard() {
        binding.root.setOnClickListener{
            val imm : InputMethodManager =
                (this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)

            if(imm.isAcceptingText){

                imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
    }


    private fun checkingIfEquals(txtTop: String, txtBottom: String): CharSequence {

        return if (txtTop == txtBottom){

            getString(R.string.equals)

        }else{
            getString(R.string.differents)
        }
    }
}