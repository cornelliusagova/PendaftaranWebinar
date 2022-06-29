package com.example.praktik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var edtNim: EditText
    private lateinit var edtNama: EditText
    private lateinit var rgJenisKelamin: RadioGroup
    private lateinit var spProdi: Spinner
    private lateinit var cbWeb: CheckBox
    private lateinit var cbSosmed: CheckBox
    private lateinit var cbTeman: CheckBox
    private lateinit var btnSubmit: Button
    private var info = ""
    private val infoArr by lazy { ArrayList<String>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtNim = findViewById(R.id.edt_nim)
        edtNama = findViewById(R.id.edt_nama)
        rgJenisKelamin = findViewById(R.id.rg_jenis_kelamin)
        spProdi = findViewById(R.id.sp_prodi)
        cbWeb = findViewById(R.id.cb_web)
        cbSosmed = findViewById(R.id.cb_sosmed)
        cbTeman = findViewById(R.id.cb_teman)
        btnSubmit = findViewById(R.id.btn_submit)

        cbWeb.setOnClickListener {
            if (cbWeb.isChecked) {
                infoArr.add(cbWeb.text.toString())
            } else {
                removeChooser(cbWeb.text.toString())
            }
        }
        cbSosmed.setOnClickListener {
            if (cbSosmed.isChecked) {
                infoArr.add(cbSosmed.text.toString())
            } else {
                removeChooser(cbSosmed.text.toString())
            }
        }
        cbTeman.setOnClickListener {
            if (cbTeman.isChecked) {
                infoArr.add(cbTeman.text.toString())
            } else {
                removeChooser(cbTeman.text.toString())
            }
        }

        btnSubmit.setOnClickListener {
            val nim = edtNim.text.toString()
            val nama = edtNama.text.toString()

            val intSelectJenisKelamin: Int = rgJenisKelamin.checkedRadioButtonId
            val rbGender = findViewById<RadioButton>(intSelectJenisKelamin)
            val gender = rbGender.text.toString()

            val prodi = spProdi.selectedItem.toString()
//            val info = StringBuilder()
            info = "$infoArr"

            info = info.replace("[", "")
            info = info.replace("]", "")
            info = info.replace(", ", "\n")

            startActivity(
                Intent(this, DetailActivity::class.java)
                    .putExtra("nim", edtNim.text.toString())
                    .putExtra("nama", edtNama.text.toString())
                    .putExtra("kelamin", rbGender.text.toString())
                    .putExtra("prodi", spProdi.selectedItem.toString())
                    .putExtra("info", info)
            )
        }
    }

    private fun removeChooser(removedItem: String) {
        if (infoArr.size!=0) {
            for (i in 0 until infoArr.size) {
                if (infoArr[i] == removedItem) {
                    infoArr.removeAt(i)
                    break
                }
            }
        }
    }
}