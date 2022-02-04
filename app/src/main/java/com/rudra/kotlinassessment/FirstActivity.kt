package com.rudra.kotlinassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.*

class FirstActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            showDialog()
        }

        val nextButton = findViewById<TextView>(R.id.nextButton)
        nextButton.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure?")

        var answer: String

        builder.setPositiveButton(android.R.string.yes) { _, _ ->
            CoroutineScope(Dispatchers.Main).launch {
                answer = printYes()
                println(answer)
            }
        }

        builder.setNegativeButton(android.R.string.no) { _, _ ->
            CoroutineScope(Dispatchers.Main).launch {
                answer = printNo()
                println(answer)
            }
        }

        builder.show()
    }

    private suspend fun printYes(): String {
        delay(500)
        return "Yes"
    }
    private suspend fun printNo(): String {
        delay(500)
        return "No"
    }
}