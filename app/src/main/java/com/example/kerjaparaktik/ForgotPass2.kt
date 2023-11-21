package com.example.kerjaparaktik

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button

class ForgotPass2 : AppCompatActivity() {
    private lateinit var btnPopup : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass2)
        supportActionBar?.hide()

        btnPopup = findViewById(R.id.btn_kirimkatasandi)
        btnPopup.setOnClickListener {
            displayPopupDialog()
        }
    }

    private fun displayPopupDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.popup_lupapw)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnMasuk = dialog.findViewById<Button>(R.id.btn_loginpop)
        btnMasuk.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        btnMasuk.setOnClickListener {
            val intent = Intent(this@ForgotPass2, Login::class.java)
            startActivity(intent)
        }
    }
}