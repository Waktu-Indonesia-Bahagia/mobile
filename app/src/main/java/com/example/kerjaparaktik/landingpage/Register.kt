package com.example.kerjaparaktik.landingpage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
//import com.example.kerjaparaktik.DbContract
//import com.example.kerjaparaktik.DbContract
import com.example.kerjaparaktik.R

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val btnDaftar: Button = findViewById(R.id.btn_daftar)
        val txtPunyaAkun: TextView = findViewById(R.id.txt_punyaakun)

        val username: EditText = findViewById(R.id.edt_nama)
        val password: EditText = findViewById(R.id.text_katasandi)
        val email: EditText = findViewById(R.id.edt_email)

//        btnDaftar.setOnClickListener(View.OnClickListener {
//            val usernameInput = username.text.toString()
//            val passwordInput = password.text.toString()
//            val emailInput = email.text.toString()
//
//            if (!(usernameInput.isEmpty() || passwordInput.isEmpty() || emailInput.isEmpty())) {
//                val stringRequest = object : StringRequest(
//                    Request.Method.POST, DbContract.urlRegister,
//                    Response.Listener { response ->
//                        Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_SHORT).show()
//                        startActivity(Intent(applicationContext, Login::class.java))
//                    },
//                    Response.ErrorListener { error ->
//                        Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
//                    }
//                ) {
//                    @Throws(AuthFailureError::class)
//                    override fun getParams(): Map<String, String> {
//                        val params = HashMap<String, String>()
//                        params["username"] = usernameInput
//                        params["password"] = passwordInput
//                        params["email"] = emailInput
//                        return params
//                    }
//                }
//
//                val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)
//                requestQueue.add(stringRequest)
//
//
//                // Tambahkan request ke queue Volley
//                // RequestQueueSingleton.getInstance(this).addToRequestQueue(stringRequest)
//            } else {
//                Toast.makeText(applicationContext, "Ada data yang masih belum terisi", Toast.LENGTH_SHORT).show()
//            }
//        })

        txtPunyaAkun.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }
    }
}
