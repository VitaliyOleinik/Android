package com.raywenderlich.android.rwandroidtutorial.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.raywenderlich.android.rwandroidtutorial.DependencyInjectorImpl
import com.raywenderlich.android.rwandroidtutorial.R
import com.raywenderlich.android.rwandroidtutorial.presenter.todo.TodoContract
import com.raywenderlich.android.rwandroidtutorial.presenter.todo.TodoPresenter
import com.raywenderlich.android.rwandroidtutorial.repository.todo.Todo
import com.raywenderlich.android.rwandroidtutorial.todo.TodoAdapter
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity(), TodoContract.View {
    private lateinit var presenter: TodoContract.Presenter
    private lateinit var todoListAdapter: TodoAdapter
    private lateinit var curTodoList: MutableList<Todo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        setPresenter(TodoPresenter(this, DependencyInjectorImpl()))

        curTodoList = presenter.getTodoList()

        todoListAdapter = TodoAdapter(curTodoList)

        todoList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = todoListAdapter
        }

        addButton.setOnClickListener {
            presenter.onTodoTaskAdded(Todo(textInput.text.toString()))
            textInput.setText("")
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTodoTasks(todoList: List<Todo>) {
        curTodoList = todoList.toMutableList()
        todoListAdapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: TodoContract.Presenter) {
        this.presenter = presenter
    }
}

