package com.example.kerjaparaktik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoarding1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding1)
        supportActionBar?.hide()

        val btnloginws: Button = findViewById(R.id.btn_lanjut1)

        btnloginws.setOnClickListener {
            val intent = Intent(this@OnBoarding1, OnBoarding2::class.java)
            startActivity(intent)
        }


    }
}