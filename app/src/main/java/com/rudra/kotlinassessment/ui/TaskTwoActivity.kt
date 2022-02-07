package com.rudra.kotlinassessment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rudra.kotlinassessment.R

class TaskTwoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.textView)

//        tn = tn-1  x 3 + tn-2
//        1,1,4,13,43,143,...

        val sequence = generateSequence ( Pair(0, 1) ) {
            Pair(it.second, (it.first * 3) + it.second)}.map { it.first }
        // [0, 1, 1, 4, 7, 19, 40, 97, 217, 508]

        textView.text = sequence.take(n).toList().toString()

        val nextButton = findViewById<TextView>(R.id.nextButton)
        nextButton.setOnClickListener{
            val intent = Intent(this, TaskThreeActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val seed = 1
        const val n = 10
    }
}