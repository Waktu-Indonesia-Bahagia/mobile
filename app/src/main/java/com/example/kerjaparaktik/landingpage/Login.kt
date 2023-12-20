package com.example.kerjaparaktik.landingpage

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjaparaktik.ApiInterface
import com.example.kerjaparaktik.ApiResponse
import com.example.kerjaparaktik.MainActivity
import com.example.kerjaparaktik.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    private lateinit var btnSignIn: ImageButton
    private val apiInterface: ApiInterface = RetrofitClient.getApiClient().create(ApiInterface::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val txt_akunbaru: TextView = findViewById(R.id.txt_akunbaru)
        val txt_lupakatasandi: TextView = findViewById(R.id.txt_lupakatasandi)
        val btn_login: Button = findViewById(R.id.btn_login)
        val name: EditText = findViewById(R.id.edt_username)
        val password: EditText = findViewById(R.id.text_katasandi)
        btnSignIn = findViewById(R.id.btn_signin)

        btnSignIn.setOnClickListener {
            displayPopupDialog()
        }




        btn_login.setOnClickListener {
            val nameInput = name.text.toString()
            val passwordInput = password.text.toString()
            val call: Call<ApiResponse> = apiInterface.performUserLogin(nameInput, passwordInput)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val apiResponse: ApiResponse? = response.body()
                        if (apiResponse?.getStatus() == "ok") {
                            if (apiResponse.getResultCode() == 1) {  // Compare as String
                                Toast.makeText(applicationContext, "Login Succesfully", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@Login, MainActivity::class.java)
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(applicationContext, "Check your Name/Password...", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Check your Name/Password...", Toast.LENGTH_SHORT).show()
                        }

                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    // Handle failure here
                }
            })
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
