package com.example.teddyshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen12)

        // Navigate to Screen02 when "Yes" is clicked
        val buttonYes = findViewById<Button>(R.id.buttonYes)
        buttonYes.setOnClickListener {
            val intent = Intent(this, Screen02::class.java)
            startActivity(intent)
            finish() // Optional: Finish current screen
        }

        // Navigate to Screen06 when "No" is clicked
        val buttonNo = findViewById<Button>(R.id.buttonNo)
        buttonNo.setOnClickListener {
            val intent = Intent(this, Screen06::class.java)
            startActivity(intent)
            finish() // Optional: Finish current screen
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
