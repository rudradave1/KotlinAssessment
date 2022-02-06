package com.rudra.kotlinassessment.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rudra.kotlinassessment.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val counterOne: TextView = findViewById(R.id.counterOne)
        val counterTwo: TextView = findViewById(R.id.counterTwo)

        //Old code
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
    }

}