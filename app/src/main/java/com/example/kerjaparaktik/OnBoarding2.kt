package com.example.kerjaparaktik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoarding2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding2)
        supportActionBar?.hide()

        val btnloginws: Button = findViewById(R.id.btn_lanjut2)

        btnloginws.setOnClickListener {
            val intent = Intent(this@OnBoarding2, OnBoarding3::class.java)
            startActivity(intent)
        }


    }
}