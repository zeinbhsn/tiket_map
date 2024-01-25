package com.example.ticket

import android.content.Intent
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TodoAdapter(var ctx: Context, var resource: Int, var items: ArrayList<Model>) : ArrayAdapter<Model>(ctx, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val title = view.findViewById<TextView>(R.id.txt_title)
        val description = view.findViewById<TextView>(R.id.txt_description)
        val img = view.findViewById<ImageView>(R.id.icon_image)

        title.text = items[position].Title
        description.text = items[position].Description
        img.setImageResource(items[position].Icon) // Set image resource

        // Tambahkan listener onClick
        view.setOnClickListener {
            val intent = Intent(ctx, PembelianTicketActivity::class.java)

            // Mengirim data terkait item yang diklik ke PembelianTicketActivity
            intent.putExtra("itemId", items[position].Id)
            ctx.startActivity(intent)
        }

        return view
    }
}

