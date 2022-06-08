package com.arun.mykotlin.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.mykotlin.R

class RecyclerActivity : AppCompatActivity() {
    lateinit var rvTodo : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        var todoList = mutableListOf(
            Todo("ffffrfrf",false),
            Todo("ffffrfrf",true),
            Todo("ffffrfrf",false),
            Todo("ffffrfrf",true),
            Todo("ffffrfrf",false),
            Todo("ffffrfrf",true),
            Todo("ffffrfrf",true),
            Todo("ffffrfrf",true),

        )

        val adapter =ToDoAdapter(todoList)
        rvTodo=findViewById(R.id.rvTodos)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        val etTodo: EditText = findViewById(R.id.etTodo)
        val btnAddTodo: Button =findViewById(R.id.btnAddd)
        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo  = Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
            etTodo.setText("")
        }
    }
}