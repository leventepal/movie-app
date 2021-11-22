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
    }

    private fun onFunctionClicked(button: Button) {
        Log.d("MovieApp", "Function button clicked: ${button.text}")
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