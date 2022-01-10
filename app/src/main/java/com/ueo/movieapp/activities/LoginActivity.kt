package com.ueo.movieapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ueo.movieapp.App
import com.ueo.movieapp.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        val etEmail: EditText = findViewById(R.id.et_email)
        val etPassword: EditText = findViewById(R.id.et_password)

        val email: String? = etEmail.text?.toString()
        val password: String? = etPassword.text?.toString()

        Log.d("MovieApp", "The auth data are: email: $email, pass: $password")

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            return
        }

        App.instance.database.userDao().let { dao ->
            dao.login(email, password)?.let {
                Toast.makeText(this, "User found", Toast.LENGTH_SHORT).show()
            } ?: kotlin.run {
                Toast.makeText(this, "User NOT found", Toast.LENGTH_SHORT).show()
            }
        }
    }

}