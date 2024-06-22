package com.example.gameapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WinningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winning)

        val player1Score = intent.getIntExtra("player1Score", 0)
        val player2Score = intent.getIntExtra("player2Score", 0)
        val winner = intent.getStringExtra("winner")

        val scoreTextView: TextView = findViewById(R.id.score)
        scoreTextView.text = "Final Score:\nPlayer 1 - $player1Score\nPlayer 2 - $player2Score\nWinner: $winner"

        val restartButton: Button = findViewById(R.id.restartButton)
        restartButton.setOnClickListener {
            finish()
        }
    }
}
