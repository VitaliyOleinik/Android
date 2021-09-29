package com.raywenderlich.android.rwandroidtutorial.todo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.raywenderlich.android.rwandroidtutorial.R
import com.raywenderlich.android.rwandroidtutorial.repository.todo.Todo

class TodoAdapter(private val list: List<Todo>) : RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TodoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo: Todo = list[position]
        holder.bind(todo, position + 1)
    }

    override fun getItemCount(): Int = list.size
}

class TodoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var mTodoTask: TextView? = null
    private var mTodoNum: TextView? = null

    init {
        mTodoTask = itemView.findViewById(R.id.todoTask)
        mTodoNum = itemView.findViewById(R.id.numeration)
    }

    fun bind(movie: Todo, position: Int) {
        mTodoTask?.text = movie.todo
        mTodoNum?.text = position.toString()
    }
}