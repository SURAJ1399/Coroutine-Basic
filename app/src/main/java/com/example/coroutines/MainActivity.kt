package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       callRxjava()

    }

    fun callCoroutine() {

        /***
         * await, withContext,suspend works in same way blocking nature inside Coroutine Scope
         * async is different non blocking nature inside Scope
         */

        //Coroutine.withContext()
        //Coroutine.suspendFunction()
        //Coroutine.asyncFunction()
        //Coroutine.awaitFunction()
        //Coroutine.joinFunction()

    }

    fun callRxjava() {

        RxJava.singleObserver()
    }

}