package com.example.kerjaparaktik.landingpage

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
//import com.example.kerjaparaktik.DbContract
//import com.example.kerjaparaktik.DbContract
import com.example.kerjaparaktik.MainActivity
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.home.HomeFragment

class Login : AppCompatActivity() {
    private lateinit var btnSignIn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val txt_akunbaru: TextView = findViewById(R.id.txt_akunbaru)
        val txt_lupakatasandi: TextView = findViewById(R.id.txt_lupakatasandi)
        val btn_login: Button = findViewById(R.id.btn_login)

        val username: EditText = findViewById(R.id.edt_username)
        val password: EditText = findViewById(R.id.text_katasandi)
        btnSignIn = findViewById(R.id.btn_signin)

        btnSignIn.setOnClickListener {
            displayPopupDialog()
        }

        btn_login.setOnClickListener {
//            val usernameInput = username.text.toString()
//            val passwordInput = password.text.toString()

            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent) }
//            if (!(usernameInput.isEmpty() || passwordInput.isEmpty())) {
//                val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)
//                val stringRequest = object : StringRequest(
//                    Request.Method.GET,
//                    "${DbContract.urlLogin}?username=$usernameInput&password=$passwordInput",
//                    Response.Listener<String> { response ->
//                        if (response == "Anda berhasil Login!") {
//                            Toast.makeText(applicationContext, "Login Berhasil!", Toast.LENGTH_SHORT).show()
//                            startActivity(Intent(applicationContext, MainActivity::class.java))
//                        } else {
//                            Toast.makeText(applicationContext, "Login Gagal!", Toast.LENGTH_SHORT).show()
//                        }
//                    },
//                    Response.ErrorListener { error ->
//                        Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
//                    }
//                ) {}
//
//                requestQueue.add(stringRequest)
//            } else {
//                Toast.makeText(applicationContext, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
//            }


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
