package com.example.ticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SecondActivity : AppCompatActivity() {
    lateinit var labelHeader : TextView
    lateinit var listTodo : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        labelHeader = findViewById(R.id.label_header)
        listTodo = findViewById(R.id.list_todo)

        var result = intent.getStringExtra("result")
        labelHeader.text = "What's up, $result?"

        val Items = ArrayList<Model>()
        Items.add(Model("1", R.mipmap.ic_aquaman_foreground, "Hello", "Coba aja"))
        Items.add(Model("2", R.mipmap.ic_dilan_foreground, "Judul pertama", "Coba aja sih"))
        Items.add(Model("3", R.mipmap.ic_aquaman_foreground, "Judul Ketiga", "Coba-coba boleh kan"))
        Items.add(Model("4", R.mipmap.ic_dilan_foreground, "Judul Keempat", "Testing 1234"))
        Items.add(Model("5", R.mipmap.ic_aquaman_foreground, "Judul Kelima", "Coba aja perhatikan semuanya deh"))


        val adapter = TodoAdapter(this, R.layout.todo_item, Items)
        listTodo.adapter = adapter
    }
}