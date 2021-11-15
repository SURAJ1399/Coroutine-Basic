package com.example.coroutines

import android.util.Log
import kotlinx.coroutines.*

object Coroutine {

    private val tag = "mainActivity"

    fun withContext() {

        /****   withcontext blocks the thread until task completion blocking nature inside Scope **/

        CoroutineScope(Dispatchers.IO).launch {

            Log.i(tag, "starting getUsers")

            withContext(Dispatchers.IO) {
                delay(5000)
                Log.i(tag, "getUsers Done")
            }
            Log.i(tag, "starting getPosts")
            getPosts()
            Log.i(tag, "coroutine Ends")

        }

        Log.i(tag, "outside launch ")

        /****  Output ******/
        // 15 Sec total time
        /* I/mainActivity: outside launch
         2021-11-13 20:30:53.548 1381-1552/com.example.coroutines I/mainActivity: starting getUsers
         2021-11-13 20:30:58.559 1381-1552/com.example.coroutines I/mainActivity: getUsers Done
         2021-11-13 20:30:58.560 1381-1552/com.example.coroutines I/mainActivity: starting getPosts
         2021-11-13 20:31:08.563 1381-1554/com.example.coroutines I/mainActivity: getPosts Done
         2021-11-13 20:31:08.564 1381-1554/com.example.coroutines I/mainActivity: coroutine Ends
    */
    }

    fun suspendFunction() {

        /*** suspend suspend the thread until completion blocking nature inside Scope  *****/

        CoroutineScope(Dispatchers.IO).launch {

            Log.i(tag, "starting getUsers")
            getUsers()
            Log.i(tag, "starting getPosts")
            getPosts()
            Log.i(tag, "coroutine Ends")

        }

        Log.i(tag, "outside launch ")


        /****  Output ******/
        // 15 Sec total time
        /* 2021-11-13 20:38:40.814 4859-4859/com.example.coroutines I/mainActivity: outside launch
         2021-11-13 20:38:40.815 4859-4889/com.example.coroutines I/mainActivity: starting getUsers
         2021-11-13 20:38:45.819 4859-4889/com.example.coroutines I/mainActivity: getUsers Done
         2021-11-13 20:38:45.819 4859-4889/com.example.coroutines I/mainActivity: starting getPosts
         2021-11-13 20:38:55.824 4859-4889/com.example.coroutines I/mainActivity: getPosts Done
         2021-11-13 20:38:55.824 4859-4889/com.example.coroutines I/mainActivity: coroutine Ends
    */
    }

    fun asyncFunction() {

        /*** non blocking code **/

        CoroutineScope(Dispatchers.Main).launch {

            Log.i(tag, "starting getUsers")
            async {
                delay(5000)
                Log.i(tag, "getUsers Done")
            }
            Log.i(tag, "starting getPosts")
            async {
                delay(10000)
                Log.i(tag, "getPosts Done")
            }
            Log.i(tag, "coroutine ends")

        }

        Log.i(tag, "outside launch ")


        /****  Output ******/
        // 10 Sec total time
        /* 2021-11-13 21:30:58.435 17663-17663/com.example.coroutines I/mainActivity: outside launch
         2021-11-13 21:30:58.436 17663-17729/com.example.coroutines I/mainActivity: starting getUsers
         2021-11-13 21:30:58.437 17663-17729/com.example.coroutines I/mainActivity: starting getPosts
         2021-11-13 21:30:58.438 17663-17729/com.example.coroutines I/mainActivity: coroutine Ends
         2021-11-13 21:31:03.440 17663-17731/com.example.coroutines I/mainActivity: getUsers Done
         2021-11-13 21:31:08.441 17663-17731/com.example.coroutines I/mainActivity: getPosts Done
  */
    }

    fun awaitFunction() {


        /*** await block code until completion like withContext blocking nature inside scope **/

        CoroutineScope(Dispatchers.Main).launch {

            Log.i(tag, "starting getUsers")
            val a = async {
                delay(5000)
                Log.i(tag, "getUsers Done")
            }
            a.await()
            Log.i(tag, "starting getPosts")
            async {
                delay(10000)
                Log.i(tag, "getPosts Done")
            }
            Log.i(tag, "coroutine Ends")

        }

        Log.i(tag, "outside launch ")


        /****  Output ******/
        // 15 Sec total time
        /*2021-11-14 00:52:29.559 7759-7759/com.example.coroutines I/mainActivity: outside launch
        2021-11-14 00:52:29.712 7759-7759/com.example.coroutines I/mainActivity: starting getUsers
        2021-11-14 00:52:34.757 7759-7759/com.example.coroutines I/mainActivity: getUsers Done
        2021-11-14 00:52:34.759 7759-7759/com.example.coroutines I/mainActivity: starting getPosts
        2021-11-14 00:52:34.760 7759-7759/com.example.coroutines I/mainActivity: coroutine Ends
       */
    }

    fun joinFunction() {


        /*** join block code until completion like withContext & await blocking nature inside scope **/

        CoroutineScope(Dispatchers.Main).launch {

            Log.i(tag, "starting getUsers")
            val a = async {
                delay(5000)
                Log.i(tag, "getUsers Done")
            }
            a.join()
            Log.i(tag, "starting getPosts")
            async {
                delay(10000)
                Log.i(tag, "getPosts Done")
            }
            Log.i(tag, "coroutine Ends")

        }

        Log.i(tag, "outside launch ")


        /****  Output ******/
        // 15 Sec total time
        /*2021-11-14 01:00:01.041 9828-9828/com.example.coroutines I/mainActivity: outside launch
        2021-11-14 01:00:01.207 9828-9828/com.example.coroutines I/mainActivity: starting getUsers
        2021-11-14 01:00:06.287 9828-9828/com.example.coroutines I/mainActivity: getUsers Done
        2021-11-14 01:00:06.297 9828-9828/com.example.coroutines I/mainActivity: starting getPosts
        2021-11-14 01:00:06.299 9828-9828/com.example.coroutines I/mainActivity: coroutine Ends
        2021-11-14 01:00:16.336 9828-9828/com.example.coroutines I/mainActivity: getPosts Done*/
    }

    private suspend fun getUsers() {
        delay(5000)
        Log.i(tag, "getUsers Done")
    }

    private suspend fun getPosts() {
        delay(10000)
        Log.i(tag, "getPosts Done")
    }

    fun add()
    {
        println("45")
    }
}