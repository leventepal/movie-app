package com.ueo.movieapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ueo.movieapp.MainActivity
import com.ueo.movieapp.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val action = Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.iv_icon).postDelayed(action, 2000L)
    }

}