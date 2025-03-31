package com.example.teddyshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen05 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen05)

        // Find views
        val image40 = findViewById<ImageView>(R.id.imageView40)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val editTextUsername = findViewById<EditText>(R.id.editText4)
        val editTextPassword = findViewById<EditText>(R.id.editText2)

        // Navigate back to Screen04
        image40.setOnClickListener { navigateToScreen04() }

        // Login button (button5) with validation
        button5.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (validateInput(username, password)) {
                val intent = Intent(this, Screen06::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Other buttons (button6 and button7) - No validation needed
        button6.setOnClickListener {
            val intent = Intent(this, Screen06::class.java)
            startActivity(intent)
            finish()
        }

        button7.setOnClickListener {
            val intent = Intent(this, Screen06::class.java)
            startActivity(intent)
            finish()
        }

        // Handle system bars (edge-to-edge display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun validateInput(username: String, password: String): Boolean {
        // Username Validation
        if (username.isEmpty()) {
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
            return false
        }

        // Password Validation
        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        }


        // Password must be at least 6 characters long
        if (password.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }


     //Navigates back to Screen04.

    private fun navigateToScreen04() {
        val intent = Intent(this, Screen04::class.java)
        startActivity(intent)
    }
}