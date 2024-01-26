package com.example.ticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent
class SecondActivity : AppCompatActivity() {
    lateinit var labelHeader : TextView
    lateinit var listTodo : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        labelHeader = findViewById(R.id.label_header)
        listTodo = findViewById(R.id.list_todo)

        labelHeader.text = "Brazein Film"

        val Items = ArrayList<Model>()
        Items.add(Model("1", R.mipmap.ic_aquaman_foreground, "Aquaman", "Laga/Petualangan"))
        Items.add(Model("2", R.mipmap.ic_dilan_foreground, "Dilan 1990", "Romance/Drama"))
        Items.add(Model("3", R.mipmap.ic_bom_foreground, "13 Bom Di Jakarta", "Laga/Petualangan"))
        Items.add(Model("4", R.mipmap.ic_budi_foreground, "Budi Pekerti", "Drama/Family Film"))
        Items.add(Model("5", R.mipmap.ic_cinta_foreground, "Jatuh Cinta Seperti Di Film-Film", "Romance/Komedi"))


        val adapter = TodoAdapter(this, R.layout.todo_item, Items)
        listTodo.adapter = adapter

        // Tambahkan listener untuk item yang diklik di ListView
        listTodo.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, PembelianTicketActivity::class.java)


        }
    }
}