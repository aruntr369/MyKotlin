package com.arun.mykotlin.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arun.mykotlin.R

class ToDoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {

//    lateinit var tvTitle :TextView

    inner class TodoViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){
        val tvTitle :TextView = itemview.findViewById(R.id.tvTitle)
        val cbDone : CheckBox = itemview.findViewById(R.id.cbDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.tvTitle.text = todos[position].title
        holder.cbDone.isChecked = todos[position].isChecked
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}