package com.example.gameapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var iv_card1: ImageView
    private lateinit var iv_card2: ImageView
    private lateinit var tv_player1: TextView
    private lateinit var tv_player2: TextView
    private lateinit var tv_war: TextView
    private lateinit var b_deal: Button
    private lateinit var random: Random
    private var player1 = 0
    private var player2 = 0
    private var cardArray = intArrayOf(
        R.drawable.img_14,
        R.drawable.img_13,
        R.drawable.img_12,
        R.drawable.img_11,
        R.drawable.img_10,
        R.drawable.img_9,
        R.drawable.img_8,
        R.drawable.img_7,
        R.drawable.img_16,
        R.drawable.img_5,
        R.drawable.img_4,
        R.drawable.img_3,
        R.drawable.img
    )
    private var winningScore = 10 // Set the winning score

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        random = Random()

        iv_card1 = findViewById(R.id.iv_card1)
        iv_card2 = findViewById(R.id.iv_card2)

        tv_player1 = findViewById(R.id.tv_player1)
        tv_player2 = findViewById(R.id.tv_player2)

        tv_war = findViewById(R.id.tv_war)
        tv_war.visibility = View.INVISIBLE

        b_deal = findViewById(R.id.b_deal)
        b_deal.setOnClickListener {
            tv_war.visibility = View.INVISIBLE

            //generate cards
            val card1 = random.nextInt(cardArray.size)
            val card2 = random.nextInt(cardArray.size)

            //set images
            setCardImage(card1, iv_card1)
            setCardImage(card2, iv_card2)

            if (card1 > card2) {
                player1++
                tv_player1.text = "Player 1: $player1"
            } else if (card1 < card2) {
                player2++
                tv_player2.text = "Player 2: $player2"
            } else {
                tv_war.visibility = View.VISIBLE
                tv_war.text = "WAR"
            }

            // if any player has reached the winning score
            if (player1 >= winningScore || player2 >= winningScore) {
                endGame() // Call function to end the game
            }
        }
    }

    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardArray[number])
    }

    private fun endGame() {
        // Display the final score
        val winner = if (player1 > player2) "Player 1" else if (player2 > player1) "Player 2" else "It's a tie!"
        val finalScore = "Final Score: Player 1 - $player1, Player 2 - $player2. $winner wins!"
        val intent = Intent(this, WinningActivity::class.java)
        intent.putExtra("player1Score", player1)
        intent.putExtra("player2Score", player2)
        intent.putExtra("winner", winner)
        startActivity(intent)
        // Reset players' scores
        player1 = 0
        player2 = 0
    }
}
