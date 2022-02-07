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

        val sequence = generateSequence ( Pair(1, 1) ) {
            Pair(it.second, it.first + (it.second * 3))}.map { it.second }
        // [ 1, 4, 13, 43, 142, 469 ]

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