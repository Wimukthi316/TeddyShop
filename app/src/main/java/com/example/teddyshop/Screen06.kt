package com.example.teddyshop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen06 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen06)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ImageView references
        val whiteBearImage = findViewById<ImageView>(R.id.imageView15)
        val redBearImage = findViewById<ImageView>(R.id.imageView16)
        val blueBearImage = findViewById<ImageView>(R.id.imageView18)
        val yelloBearImage = findViewById<ImageView>(R.id.imageView14)

        val profileImage = findViewById<ImageView>(R.id.imageView21) // Navigate to Screen11
        val exitImage = findViewById<ImageView>(R.id.imageView23) // Navigate to Screen12

        // Set click listeners
        whiteBearImage.setOnClickListener {
            val intent = Intent(this, Screen07::class.java)
            startActivity(intent)
        }

        redBearImage.setOnClickListener {
            val intent = Intent(this, Screen08::class.java)
            startActivity(intent)
        }

        blueBearImage.setOnClickListener {
            val intent = Intent(this, Screen07::class.java)
            startActivity(intent)
        }

        yelloBearImage.setOnClickListener {
            val intent = Intent(this, Screen08::class.java)
            startActivity(intent)
        }

        // Navigate to Screen11 when profile icon is clicked
        profileImage.setOnClickListener {
            val intent = Intent(this, Screen11::class.java)
            startActivity(intent)
        }

        // Navigate to Screen12 when exit icon is clicked
        exitImage.setOnClickListener {
            val intent = Intent(this, Screen12::class.java)
            startActivity(intent)
        }
    }
}
