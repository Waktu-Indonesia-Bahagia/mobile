package com.example.kerjaparaktik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
        supportActionBar?.hide()

        val btnloginws: Button = findViewById(R.id.btn_loginws)
        val btndaftarws: Button = findViewById(R.id.btn_daftarws)

        btnloginws.setOnClickListener {
            val intent = Intent(this@WelcomeScreen, Login::class.java)
            startActivity(intent)
        }

        btndaftarws.setOnClickListener {
            val intent = Intent(this@WelcomeScreen, Register::class.java)
            startActivity(intent)
        }

    }
}