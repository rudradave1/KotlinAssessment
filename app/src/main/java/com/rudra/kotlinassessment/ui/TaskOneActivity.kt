package com.rudra.kotlinassessment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rudra.kotlinassessment.R
import com.xeinebiu.suspend.dialogs.SuspendAlertDialog
import com.xeinebiu.suspend.dialogs.confirm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val button: Button = findViewById(R.id.button)
        val nextButton: Button = findViewById(R.id.nextButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val result = showDialog("Are you sure?")
                resultTextView.text = result.toString()
            }
        }

        nextButton.setOnClickListener{
            val intent = Intent(this, TaskTwoActivity::class.java)
            startActivity(intent)
        }
    }

    // function to display the dialog
    private suspend fun showDialog(message: String): SuspendAlertDialog.DialogAction {

        val result = SuspendAlertDialog.confirm(
            positiveButtonText = "Yes",
            negativeButtonText = "No",
            neutralButtonText = "Neutral"
        ) {
            MaterialAlertDialogBuilder(this)
                .setTitle(message)
                .setMessage("Message")
        }

        return result
    }

}