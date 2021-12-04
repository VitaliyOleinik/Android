package com.raywenderlich.android.rwandroidtutorial.repository.todo

interface TodoRepository {
    fun loadTodos(): TodoResponse
}