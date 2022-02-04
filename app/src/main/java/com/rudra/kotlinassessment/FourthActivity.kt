package com.rudra.kotlinassessment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val counterOne: TextView = findViewById(R.id.counterOne)
        val counterTwo: TextView = findViewById(R.id.counterTwo)

        val flowOne = flow<Int> {
            for (i in 0..5){
                emit(i)
                delay(1000)
            }
        }


        val flowTwo = flow<Int> {
            for (i in 10 downTo 0){
                emit(i)
                delay(1000)
            }
        }

        GlobalScope.launch{
            flowOne.collect {
                counterOne.text = it.toString()
            }
            flowTwo.collect {
                counterTwo.text = it.toString()
            }
        }
    }

}