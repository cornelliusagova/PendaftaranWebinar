package com.example.praktik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var textNIM : TextView
    private lateinit var textNama : TextView
    private lateinit var textKlmn : TextView
    private lateinit var textProdi : TextView
    private lateinit var textInfo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textNIM = findViewById(R.id.tv_nim)
        textNama = findViewById(R.id.tv_nama)
        textKlmn = findViewById(R.id.tv_kelamin)
        textProdi = findViewById(R.id.tv_Prodi)
        textInfo = findViewById(R.id.tv_info)


        val userName = intent.getStringExtra("nim")
        val password = intent.getStringExtra("nama")
        val klmn   = intent.getStringExtra("kelamin")
        val prodix = intent.getStringExtra("prodi")
        val infox = intent.getStringExtra("info")

        textNIM.text = "NIM  : "+userName
        textNama.text = "NAMA : "+password
        textKlmn.text = "Jenis Kelamin : "+klmn
        textProdi.text = "Prodi : "+prodix
        textInfo.text = "Info Dari : "+infox



    }
}