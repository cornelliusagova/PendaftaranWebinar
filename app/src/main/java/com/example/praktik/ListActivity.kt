package com.example.praktik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private val data : ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        data.add(
            DataModel(
                "5200411479",
                "Gova"
            )
        )

        data.add(
            DataModel(
                "5200411111",
                "AZAZA"
            )
        )

        data.add(
            DataModel(
                "520041122",
                "xxx"
            )
        )

        val listaAdapter = ListAdapter(this)

        val rvWebinar = findViewById<RecyclerView>(R.id.rv_webinar)
        with(rvWebinar){
            layoutManager = GridLayoutManager(this@ListActivity, 2)
            setHasFixedSize(true)
            adapter = listaAdapter
        }
        listaAdapter.setData(data)
    }
}