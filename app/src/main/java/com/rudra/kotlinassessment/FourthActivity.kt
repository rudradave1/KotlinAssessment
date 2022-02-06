package com.rudra.kotlinassessment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.streams.asStream

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val counterOne: TextView = findViewById(R.id.counterOne)
        val counterTwo: TextView = findViewById(R.id.counterTwo)

        /*val randomNumber = (0..10).random()

        val flowOne = flow<Int> {
            while(true){
                emit(randomNumber)
                delay(1000)
            }
        }

        val flowTwo = flow<Int> {
//            for (i in 10 downTo 0){
//                emit(i)
//                delay(1000)
//            }
            while(true){
                emit(randomNumber)
                delay(1000)
            }
        }

        GlobalScope.launch{
            flowOne.collect {
                counterOne.text = it.toString()

                flowTwo.collect { next ->
                    counterTwo.text = next.toString()
                }
            }
        }
        */

        val listOne = listOf(1, 1, 3, 3, 3, 4, 5, 8, 12, 12, 13, 13, 13, 13)
        val listTwo = listOf(5,5,25,25,25,25,75,75,100,200,200,225)

        val flow = flow {
            emit(listOne.plus(listTwo).groupingBy { it }.eachCount())
        }

        GlobalScope.launch{
            flow.collect {
                counterOne.text = it.toString()
            }
        }
    }

}