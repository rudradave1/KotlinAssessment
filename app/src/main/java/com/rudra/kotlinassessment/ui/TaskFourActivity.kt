package com.rudra.kotlinassessment.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.rudra.kotlinassessment.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class TaskFourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val counterOne: TextView = findViewById(R.id.counterOne)
        val counterTwo: TextView = findViewById(R.id.counterTwo)


        lifecycleScope.launch { // Dispatchers.Main
            val flowA = flow {
                var i: Int = 0
                for (i in 0..100) {
                    if (i % 2 == 0){
                        delay(2000)
                        emit(i)
                    }
                }
            }
            val flowB = flow {
                var i: Int = 0
                for (i in 0..100) {
                    if(i % 2 != 0){
                        delay(5000)
                        emit(i)
                    }
                }
            }

            merge(flowA, flowB).collect { println(it.toString()) } // Prints two integers
/*
        //created two list generating random numbers to count frequencies
        val listOne =  List(10) { Random.nextInt(0, 10) }
        val listTwo =  List(10) { Random.nextInt(0, 10) }

        // Just displaying the data
        val combinedListString = """List-1 -> $listOne 
            |List-2 -> $listTwo
            |Combined list -> ${listOne.plus(listTwo).sortedBy { it }}"""
        counterTwo.text = combinedListString.trimMargin()

        // A flow that emits map of occurrences of the int.
        val flow = flow {
            emit(listOne.plus(listTwo).sortedBy { it }.groupingBy { it }.eachCount())
        }

        //Collecting the results and printing it. k
        GlobalScope.launch{
            flow.collect {
                counterOne.text = it.toString()
            }
        }
    }*/
        }
    }
}