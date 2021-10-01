package com.maco.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        rv_todoList.adapter = todoAdapter
        rv_todoList.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = edtTodoName.text.toString()

            if(todoTitle.isNotEmpty()){

                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                edtTodoName.text.clear()
            }

        }

        btnDeleteTodo.setOnClickListener {
            todoAdapter.removeTodo()
        }


    }
}