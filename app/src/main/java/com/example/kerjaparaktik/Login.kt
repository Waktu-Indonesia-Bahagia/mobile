package com.example.kerjaparaktik

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Login : AppCompatActivity() {
    private lateinit var btnSignIn : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val txt_akunbaru: TextView = findViewById(R.id.txt_akunbaru)
        val txt_lupakatasandi: TextView = findViewById(R.id.txt_lupakatasandi)

        btnSignIn = findViewById(R.id.btn_signin)
        btnSignIn.setOnClickListener {
            displayPopupDialog()
        }


        txt_akunbaru.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }
        txt_lupakatasandi.setOnClickListener {
            val intent = Intent(this@Login, ForgotPass::class.java)
            startActivity(intent)
        }
    }
    private fun displayPopupDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.popup_signingoogle)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnKonfirmasi = dialog.findViewById<Button>(R.id.btn_konfirmasi)
        btnKonfirmasi.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        btnKonfirmasi.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }
    }
}
