package com.raywenderlich.android.rwandroidtutorial.presenter.todo

import com.raywenderlich.android.rwandroidtutorial.BasePresenter
import com.raywenderlich.android.rwandroidtutorial.BaseView
import com.raywenderlich.android.rwandroidtutorial.repository.todo.Todo

interface TodoContract {
    interface Presenter : BasePresenter {
        fun getTodoList(): MutableList<Todo>
        fun onTodoTaskAdded(todo: Todo)
    }

    interface View : BaseView<Presenter> {
        fun showTodoTasks(todoList: List<Todo>)
    }
}