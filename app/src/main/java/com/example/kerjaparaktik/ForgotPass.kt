package com.example.kerjaparaktik

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView

class ForgotPass : AppCompatActivity() {
    private lateinit var btnPopup : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        supportActionBar?.hide()

        val btnloginws: Button = findViewById(R.id.btn_aturkatasandi)

        btnloginws.setOnClickListener {
            val intent = Intent(this@ForgotPass, ForgotPass2::class.java)
            startActivity(intent)
        }


    }
}