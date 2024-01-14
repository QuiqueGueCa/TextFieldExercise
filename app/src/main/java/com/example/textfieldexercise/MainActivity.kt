package com.example.textfieldexercise

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.textfieldexercise.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            etTop.setOnFocusChangeListener {
                    _, _ -> tvTxtToShow.text = getString(R.string.writtingTop) }

            etBottom.setOnFocusChangeListener {
                    _, _ -> tvTxtToShow.text = getString(R.string.writtingBot) }

            btnChecker.setOnClickListener {
                tvTxtToShow.text = checkingIfEquals(etTop.text.toString(), etBottom.text.toString())
            }

            touchingScreen(etTop, etBottom, tvTxtToShow)
        }
    }


    private fun touchingScreen(etTop: TextInputEditText, etBottom: TextInputEditText, tvTxtToShow: TextView) {
        binding.root.setOnClickListener{

            quitingKeyboard()

            etTop.clearFocus()
            etBottom.clearFocus()
            tvTxtToShow.text = ""
        }
    }

    private fun quitingKeyboard() {
        val imm : InputMethodManager =
            (this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)

        if(imm.isAcceptingText){

            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
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