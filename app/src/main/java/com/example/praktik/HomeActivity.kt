package com.example.praktik

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    lateinit var btnActivity : Button
    lateinit var btnData : Button
    lateinit var btnImplicit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnActivity = findViewById(R.id.btn_activity)
        btnData =  findViewById(R.id.btn_data)
        btnImplicit = findViewById(R.id.btn_implicit)

        btnActivity.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("key_detail", "gova")
            startActivity(intent)
        }

        btnData.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("key_detail", "cornellius")
            startActivity(intent)
        }

        btnImplicit.setOnClickListener {
            val phoneNumber = "0895359075297"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
    }
}