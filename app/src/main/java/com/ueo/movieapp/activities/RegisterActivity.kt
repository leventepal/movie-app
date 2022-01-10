package com.ueo.movieapp.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ueo.movieapp.App
import com.ueo.movieapp.R
import com.ueo.movieapp.database.User

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.btn_register).setOnClickListener {
            register()
        }
    }

    private fun register() {
        val email: String? = findViewById<EditText>(R.id.et_email).text?.toString()
        val confirmEmail: String? = findViewById<EditText>(R.id.et_email_confirm).text?.toString()
        val firstName: String? = findViewById<EditText>(R.id.et_first_name).text?.toString()
        val lastName: String? = findViewById<EditText>(R.id.et_last_name).text?.toString()
        val password: String? = findViewById<EditText>(R.id.et_password).text?.toString()

        if (email != confirmEmail) {
            Toast.makeText(this, R.string.email_mismatch, Toast.LENGTH_SHORT).show()
            return
        }

        if (email.isNullOrEmpty()) {
            Toast.makeText(this, R.string.invalid_email_address, Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isNullOrEmpty()) {
            Toast.makeText(this, R.string.invalid_password, Toast.LENGTH_SHORT).show()
            return
        }

        App.instance.database.userDao().let { dao ->
            val user = User(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password
            )

            dao.insertAll(user)
        }
    }

}