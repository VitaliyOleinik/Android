package com.raywenderlich.android.rwandroidtutorial.data.counter

import kotlin.random.Random

class CounterRepositoryImpl : CounterRepository {
    override fun loadCounter(): CounterModel {
        val counter = List(1) { Random.nextInt(1, 100) }
        return CounterModel(counter = counter[0])
    }
}