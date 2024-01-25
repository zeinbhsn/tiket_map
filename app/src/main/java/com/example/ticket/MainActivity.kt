// MainActivity.kt
package com.example.ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnSubmit: Button
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit = findViewById(R.id.loginButton)
        etUsername = findViewById(R.id.loginUsername)
        etPassword = findViewById(R.id.loginPassword)

        btnSubmit.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Isi data dengan benar",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
