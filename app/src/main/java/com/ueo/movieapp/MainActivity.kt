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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)

        val btnIds = listOf<Int>(
           R.id.btn_0,
           R.id.btn_1,
           R.id.btn_2,
           R.id.btn_dec
        )

        btnIds.forEach { btnId ->
            val button = findViewById<Button>(btnId)
            this.buttonsList.add(button)
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