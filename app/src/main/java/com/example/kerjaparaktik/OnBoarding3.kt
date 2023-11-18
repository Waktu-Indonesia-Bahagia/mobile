package com.example.kerjaparaktik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoarding3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding3)
        supportActionBar?.hide()

        val btnloginws: Button = findViewById(R.id.btn_lanjut3)

        btnloginws.setOnClickListener {
            val intent = Intent(this@OnBoarding3, WelcomeScreen::class.java)
            startActivity(intent)
        }


    }
}