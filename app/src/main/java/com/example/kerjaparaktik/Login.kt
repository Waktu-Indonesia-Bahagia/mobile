package com.example.kerjaparaktik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val txt_akunbaru: TextView = findViewById(R.id.txt_akunbaru)
        val txt_lupakatasandi: TextView = findViewById(R.id.txt_lupakatasandi)


        txt_akunbaru.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }
        txt_lupakatasandi.setOnClickListener {
            val intent = Intent(this@Login, ForgotPass::class.java)
            startActivity(intent)
        }

    }
}