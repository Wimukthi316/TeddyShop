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

class Screen04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen04)

        val button4 = findViewById<Button>(R.id.button4)
        val editTextName = findViewById<EditText>(R.id.editText4)
        val editTextMobile = findViewById<EditText>(R.id.editText)
        val editTextEmail = findViewById<EditText>(R.id.editText3)
        val editTextPassword = findViewById<EditText>(R.id.editText2)
        val editTextConfirmPassword = findViewById<EditText>(R.id.editText2) // Note: This ID is duplicated, you should fix it in your XML

        button4.setOnClickListener {
            val name = editTextName.text.toString()
            val mobile = editTextMobile.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()

            if (validateInput(name, mobile, email, password, confirmPassword)) {
                val intent = Intent(this, Screen05::class.java)
                startActivity(intent)
                finish()
            }
        }

        val image35 = findViewById<ImageView>(R.id.imageView35)
        image35.setOnClickListener { navigateToScreen03("Screen02") }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun validateInput(
        name: String,
        mobile: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        // Name Validation
        if (name.isEmpty() || !name.matches(Regex("^[a-zA-Z ]+\$"))) {
            Toast.makeText(this, "Please enter a valid name (letters only)", Toast.LENGTH_SHORT).show()
            return false
        }

        // Mobile Number Validation
        if (mobile.isEmpty() || !mobile.matches(Regex("^[0-9]+\$"))) {
            Toast.makeText(this, "Please enter a valid mobile number (digits only)", Toast.LENGTH_SHORT).show()
            return false
        }

        // Email Validation
        if (email.isEmpty() || !email.contains("@")) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            return false
        }

        // Password Validation
        if (password.isEmpty() || password.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
            return false
        }

        // Confirm Password Validation
        if (confirmPassword.isEmpty() || password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun navigateToScreen03(s: String) {
        val intent = Intent(this, Screen03::class.java)
        startActivity(intent)
    }
}

