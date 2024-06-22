package com.example.gameapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView2)

        imageView.setOnClickListener {
            // Start the new activity
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
