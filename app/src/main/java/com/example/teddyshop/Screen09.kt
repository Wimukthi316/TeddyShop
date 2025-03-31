package com.example.teddyshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen09 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen09)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Back button navigation to Screen06
        val backButton = findViewById<ImageView>(R.id.imageView30)
        backButton.setOnClickListener {
            val intent = Intent(this, Screen06::class.java)
            startActivity(intent)
            finish() // Remove Screen09 from the stack
        }

        // Order button navigation to Screen10
        val orderButton = findViewById<Button>(R.id.Order)
        orderButton.setOnClickListener {
            val intent = Intent(this, Screen10::class.java)
            startActivity(intent)
            finish() // Remove Screen09 from the stack
        }
    }
}
