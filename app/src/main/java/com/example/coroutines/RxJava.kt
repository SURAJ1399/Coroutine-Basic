package com.example.coroutines

import android.util.Log
import android.widget.Toast
import io.reactivex.rxjava3.core.Single

object RxJava {

    fun singleObserver(){
        val list = mutableListOf<String>("1","2","3")
        Single.just(list).map {
            it.map {
                Log.i("singleObserver", it)
            }
        }.subscribe()
    }








}