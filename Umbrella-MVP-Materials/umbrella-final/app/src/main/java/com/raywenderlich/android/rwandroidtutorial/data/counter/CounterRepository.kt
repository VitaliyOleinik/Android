package com.raywenderlich.android.rwandroidtutorial.data.counter

interface CounterRepository {
    fun loadCounter(): CounterModel
}