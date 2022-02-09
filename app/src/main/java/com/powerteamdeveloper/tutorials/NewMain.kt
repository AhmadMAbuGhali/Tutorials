package com.powerteamdeveloper.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_new_main.*

class NewMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_main)
        var todoList = mutableListOf(
            Todo("follow AndroidDeves ",false),
            Todo("follow Ahmnad ",false),
            Todo("follow Deves ",false),
            Todo("follow Me",false),
            Todo("Like AndroidDeves ",false)
        )
        val adapter =TodoAdapter(todoList)
        rvTodos.adapter =adapter
        rvTodos.layoutManager =LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val titel =etTodo.text.toString()
            val todo = Todo(titel,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}