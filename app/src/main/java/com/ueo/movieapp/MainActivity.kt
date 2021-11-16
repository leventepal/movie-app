package com.ueo.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_7)
        button.setOnClickListener {
            Log.d("Calc", "btn 7 pressed")
        }

        val button8 = findViewById<Button>(R.id.btn_8)
        button8.setOnClickListener {
            Log.e("Calc", "btn 8 pressed")
            val toast = Toast.makeText(this, "Btn 8 was pressed", Toast.LENGTH_LONG)
            toast.show()
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