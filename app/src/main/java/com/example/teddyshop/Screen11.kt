package com.example.teddyshop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen11)

        // Navigate to Screen06 when clicking the back arrow
        val backArrow = findViewById<ImageView>(R.id.back_Arrow)
        backArrow.setOnClickListener {
            navigateToScreen06()
        }

        // Navigate to Screen06 when clicking the home icon
        val homeIcon = findViewById<ImageView>(R.id.imageView19)
        homeIcon.setOnClickListener {
            navigateToScreen06()
        }

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigate to Screen12 when clicking the exit icon
        val exitImage = findViewById<ImageView>(R.id.imageView63)
        exitImage.setOnClickListener {
            val intent = Intent(this, Screen12::class.java)
            startActivity(intent)
        }
    }

    // Helper function to navigate to Screen06
    private fun navigateToScreen06() {
        val intent = Intent(this, Screen06::class.java)
        startActivity(intent)
        finish() // Optional: Close Screen11 if you don't want to return to it
    }
}
