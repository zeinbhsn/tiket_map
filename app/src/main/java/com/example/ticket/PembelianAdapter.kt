package com.example.ticket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PembelianAdapter (var ctx: Context, var resource: Int, var item: ArrayList<PembelianModel>): ArrayAdapter<PembelianModel>(ctx, resource, item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val title = view.findViewById<TextView>(R.id.txt_judultiket)
        val description = view.findViewById<TextView>(R.id.txt_description)

        title.text = item[position].JudulFilm
        description.text = item[position].JumlahTiketYangDibeli

        return view
    }
}