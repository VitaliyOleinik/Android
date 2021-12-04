package com.raywenderlich.android.rwandroidtutorial.presenter.todo

import com.raywenderlich.android.rwandroidtutorial.DependencyInjector
import com.raywenderlich.android.rwandroidtutorial.repository.todo.Todo
import com.raywenderlich.android.rwandroidtutorial.repository.todo.TodoRepository

class TodoPresenter(
    view: TodoContract.View,
    dependencyInjector: DependencyInjector
) : TodoContract.Presenter {
    private val toDoRepository: TodoRepository = dependencyInjector.todoRepository()
    private var view: TodoContract.View? = view
    private var curTodoList: MutableList<Todo>? = null

    override fun onDestroy() {
        this.view = null
    }

    override fun getTodoList(): MutableList<Todo> {
        curTodoList = toDoRepository.loadTodos().todoList?.toMutableList()
        return curTodoList!!
    }

    override fun onTodoTaskAdded(todo: Todo) {
        curTodoList?.add(todo)
        view?.showTodoTasks(curTodoList!!)
    }
}