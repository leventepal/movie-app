package com.ueo.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvResult: TextView? = null
    private val buttonsList = mutableListOf<Button>()
    private val buttonFunctions = mutableListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)

        val btnIds = listOf<Int>(
            R.id.btn_0,
            R.id.btn_1,
            R.id.btn_2,
            R.id.btn_dec,
            R.id.btn_3,
            R.id.btn_4,
            R.id.btn_5,
            R.id.btn_6,
            R.id.btn_7,
            R.id.btn_8,
            R.id.btn_9
        )

        btnIds.forEach { btnId ->
            val button = findViewById<Button>(btnId)
            this.buttonsList.add(button)
        }

        buttonsList.forEach { button ->
            button.setOnClickListener {
                onNumberClick(button)
            }
        }

        listOf(R.id.btn_result, R.id.btn_sum, R.id.btn_subs, R.id.btn_mult).forEach { btnId ->
            findViewById<Button>(btnId).setOnClickListener { view ->
                onFunctionClicked(view as Button)
            }
        }
    }

    private fun onNumberClick(button: Button) {
        // .getText() or .text are identical
        Log.d("MovieApp", "Button pressed: ${button.text}")

        val value: String = button.text.toString()
        this.tvResult?.let { tvResult ->
            try {
                val newResult: String = tvResult.text.toString() + value
                val value: String = if (newResult.contains(".")) {
                    newResult.toFloat()
                } else {
                    newResult.toInt()
                }.toString()

                tvResult.text = value
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    private fun onFunctionClicked(button: Button) {
        Log.d("MovieApp", "Function button clicked: ${button.text}")
    }

    private fun sum(leftValue: Int, rightValue: Int): Int {
        return leftValue + rightValue
    }

    override fun onBackPressed() {
        // super.onBackPressed()

        this.tvResult?.let { tvResult ->
            val text: String = tvResult.text.toString()

            if (text.isEmpty()) {
                super.onBackPressed()
            } else {
                // [a, b, c, 1, 2, 3]
                // [0, 1, 2, 3, 4, 5]
                // abc123 -> abc12
                //

                text.substring(0, text.length - 1).let { newText ->
                    tvResult.setText(newText)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}