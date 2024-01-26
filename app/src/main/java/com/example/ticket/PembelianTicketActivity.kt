package com.example.ticket

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.content.Intent

class PembelianTicketActivity : AppCompatActivity() {

    lateinit var listTiket : ListView
    lateinit var btnCreatePembelian : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembelian_ticket)

        listTiket = findViewById(R.id.list_tiket)
        btnCreatePembelian = findViewById(R.id.btn_create_pembelian)

        val db = Firebase.firestore
        db.collection("pembelian")
            .get()
            .addOnSuccessListener { result ->
                val Items = ArrayList<PembelianModel>()

                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    Items.add(
                        PembelianModel(
                            document.data.get("judulFilm").toString(),
                            document.data.get("jumlahTiketYangDibeli").toString()
                        )
                    )
                }


                val adapter = PembelianAdapter(this, R.layout.pembelian_item, Items)
                listTiket.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

        btnCreatePembelian.setOnClickListener {
            val intent = Intent(this, CreatePembelianActivity::class.java)
            startActivity(intent)


        }
    }
}
