package com.example.kerjaparaktik.landingpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjaparaktik.ApiInterface
import com.example.kerjaparaktik.ApiResponse
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.notification.NotificationData
import com.example.kerjaparaktik.profile.UbahSandiFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {

    private val apiInterface: ApiInterface = RetrofitClient.getApiClient().create(ApiInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val btnDaftar: Button = findViewById(R.id.btn_daftar)
        val txtPunyaAkun: TextView = findViewById(R.id.txt_punyaakun)

        val name: EditText = findViewById(R.id.edt_nama)
        val password: EditText = findViewById(R.id.text_katasandi)
        val email: EditText = findViewById(R.id.edt_email)

        btnDaftar.setOnClickListener {
            val nameInput = name.text.toString()
            val passwordInput = password.text.toString()
            val emailInput = email.text.toString()

            val fragment = UbahSandiFragment()
            val bundle = Bundle()
            bundle.putString("email",emailInput)
            fragment.arguments = bundle

            val notification = NotificationData("Selamat","datang di Aplikasi Kami ini,Aplikasi inibertujuan bagi Mahasiswa yang ingin kerja praktik")
            senDataNotification(notification)

            val call: Call<ApiResponse> = apiInterface.performUserSignIn(nameInput, passwordInput, emailInput)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val apiResponse: ApiResponse? = response.body()
                        if (apiResponse?.getStatus() == "ok") {
                            if (apiResponse.getResultCode() == 1) {  // Compare as String
                                Toast.makeText(this@Register, "Registration Success!", Toast.LENGTH_SHORT).show()
                                onBackPressed()
                                finish()
                            } else {
                                Toast.makeText(applicationContext, "User Already Exist....", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "User Already Exist....", Toast.LENGTH_SHORT).show()
                        }

                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    // Handle failure here
                    t.printStackTrace()
                }
            })
        }

        txtPunyaAkun.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }
    }

    private fun senDataNotification(notification: NotificationData) {
        val call: Call<Void> = apiInterface.notification(notification.title, notification.message)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Data berhasil dikirim
                    println("Data berhasil dikirim ke server.")
                } else {
                    // Gagal mengirim data
                    println("Gagal mengirim data ke server. ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Handle failure here
                t.printStackTrace()
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
