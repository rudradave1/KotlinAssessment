package com.rudra.kotlinassessment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.rudra.kotlinassessment.R
import kotlinx.coroutines.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val button: Button = findViewById(R.id.button)
        val nextButton: Button = findViewById(R.id.nextButton)

        button.setOnClickListener {
            showDialog()
        }

        nextButton.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    // function to display the dialog
    private fun showDialog() {
        var answer: String
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure?")

        builder.setPositiveButton(android.R.string.yes) { _, _ ->
            CoroutineScope(Dispatchers.Main).launch {
                answer = printYes()
                resultTextView.text = answer
            }
        }

        builder.setNegativeButton(android.R.string.no) { _, _ ->
            CoroutineScope(Dispatchers.Main).launch {
                answer = printNo()
                resultTextView.text = answer
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