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
    private var lastFunction: Functions? = null
    private var oldValue: String? = null

    companion object {
        private const val TAG = "MovieApp"
    }

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
        Log.d(TAG, "Button pressed: ${button.text}")

        val value: String = button.text.toString()
        this.tvResult?.let { tvResult ->
            try {
                if (this.lastFunction != null) {
                    this.oldValue = tvResult.text.toString()
                    this.lastFunction = null

                    val value: String = if (value.contains(".")) {
                        value.toFloat()
                    } else {
                        value.toInt()
                    }.toString()

                    tvResult.text = value
                } else {
                    val newResult: String = tvResult.text.toString() + value
                    val value: String = if (newResult.contains(".")) {
                        newResult.toFloat()
                    } else {
                        newResult.toInt()
                    }.toString()

                    tvResult.text = value
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    private fun onFunctionClicked(button: Button) {
        Log.d(TAG, "Function button clicked: ${button.text}")

        val oldLastFunction = this.lastFunction

        this.lastFunction = when (button.id) {
            R.id.btn_mult -> Functions.MULTIPLY
                R.id.btn_subs -> Functions.SUBTRACT
                R.id.btn_sum -> Functions.SUM
                R.id.btn_result -> Functions.EQUAL
                else -> null
        }

        Log.d(TAG, "Last function is: $lastFunction")
        this.tvResult?.let { tvResult ->
            Toast.makeText(this, this.lastFunction?.name ?: "", Toast.LENGTH_SHORT).show()
        }

        if (this.lastFunction == Functions.EQUAL) {
            when (oldLastFunction) {
                Functions.SUM -> sum()
            }
        }
    }

    private fun sum() {
        this.oldValue?.let { oldValue ->
            this.tvResult?.text?.toString()?.let { newValue ->
                val result = oldValue.toFloat() + newValue.toFloat()
                this.tvResult?.setText(result.toString())
            }
        }
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