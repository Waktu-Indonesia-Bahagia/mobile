package com.example.kerjaparaktik.landingpage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjaparaktik.R

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val btnDaftar: Button = findViewById(R.id.btn_daftar)
        val txtPunyaAkun: TextView = findViewById(R.id.txt_punyaakun)


        btnDaftar.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }

        txtPunyaAkun.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }

    }
}
