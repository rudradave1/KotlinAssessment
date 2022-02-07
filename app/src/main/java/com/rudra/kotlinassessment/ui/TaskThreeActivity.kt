package com.rudra.kotlinassessment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rudra.kotlinassessment.R
import com.rudra.kotlinassessment.data.Group
import com.rudra.kotlinassessment.data.PlayerGame

class TaskThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        val match = listOf(

            PlayerGame("3", Group.BLUE, 12),

            PlayerGame("45", Group.BLUE, 20),

            PlayerGame("8", Group.BLUE, 17),

            PlayerGame("30", Group.BLUE, 8),

            PlayerGame("21", Group.BLUE, 17),

            PlayerGame("3", Group.RED, 12),

            PlayerGame("4", Group.RED, 7),

            PlayerGame("7", Group.RED, 20),

            PlayerGame("10", Group.RED, 16),

            PlayerGame("15", Group.RED, 4),

            PlayerGame("40", Group.RED, 26)

        )


        //Solution line
        //Sorted by player number
        val scoreBoard = match.groupingBy{it.group}.fold(0) {sum, element -> sum + element.score}

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = scoreBoard.toString()

        val nextButton = findViewById<TextView>(R.id.nextButton)
        nextButton.setOnClickListener{
            val intent = Intent(this, TaskFourActivity::class.java)
            startActivity(intent)
        }
    }
}