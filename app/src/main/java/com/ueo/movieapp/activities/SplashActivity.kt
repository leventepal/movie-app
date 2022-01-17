package com.ueo.movieapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ueo.movieapp.App
import com.ueo.movieapp.MainActivity
import com.ueo.movieapp.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val action = Runnable {
//            App.instance.database.let { db ->
//                val users = db.userDao().getAll()
//
//                if (users.isEmpty()) {
//                    startActivity(Intent(this, RegisterActivity::class.java))
//                } else {
//                    startActivity(Intent(this, LoginActivity::class.java))
//                }
//            }

            startActivity(Intent(this, MovieActivity::class.java))

            finish()
        }

        findViewById<ImageView>(R.id.iv_icon).postDelayed(action, 2000L)
    }

}