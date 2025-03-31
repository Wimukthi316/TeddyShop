package com.example.teddyshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView

class Screen08 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen08)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the back arrow ImageView
        val backArrow = findViewById<ImageView>(R.id.back_Arrow)

        // Set click listener
        backArrow.setOnClickListener {
            val intent = Intent(this, Screen06::class.java)
            startActivity(intent)
        }

        // Find the "Add Order" button
        val addOrderButton = findViewById<Button>(R.id.AddOrder)

        // Set click listener
        addOrderButton.setOnClickListener {
            val intent = Intent(this, Screen09::class.java)
            startActivity(intent)
        }
    }
}