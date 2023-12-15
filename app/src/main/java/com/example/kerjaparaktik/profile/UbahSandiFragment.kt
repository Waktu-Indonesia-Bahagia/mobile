package com.example.kerjaparaktik.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kerjaparaktik.DbContract
import com.example.kerjaparaktik.R
import java.util.HashMap

class UbahSandiFragment : Fragment(), View.OnClickListener {
    private var email: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ubah_sandi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnUbah: Button = view.findViewById(R.id.btn_ubah)
        btnUbah.setOnClickListener(this)

        val ivBack: ImageView = view.findViewById(R.id.iv_arrow_back_sandi)
        ivBack.setOnClickListener(this)



        fetchEmailFromServer()
    }

    private fun fetchEmailFromServer() {
        val stringRequest = object : StringRequest(
            Request.Method.GET,
            DbContract.urlRegister,
            Response.Listener { response ->
                email = response
            },
            Response.ErrorListener { error ->
                message(error.message)
            }
        ) {}

        val queue: RequestQueue = Volley.newRequestQueue(requireContext())
        queue.add(stringRequest)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_ubah -> {
                val old_password: EditText = requireView().findViewById(R.id.edt_sandi_lama)
                val new_password: EditText = requireView().findViewById(R.id.edt_sandi_baru)
                val conform_password: EditText = requireView().findViewById(R.id.edt_sandi_baru_lagi)

                val oldPassword = old_password.text.toString().trim()
                val newPassword = new_password.text.toString().trim()
                val conformPassword = conform_password.text.toString().trim()
                val emailKt = email

                if (oldPassword.isEmpty() || newPassword.isEmpty() || conformPassword.isEmpty()) {
                    message("Masih ada yang Kosong!")
                } else {
                    val stringRequest = object : StringRequest(
                        Request.Method.POST,
                        DbContract.UrlResetPassword,
                        Response.Listener { response ->
                            handleResponse(response)
                        },
                        Response.ErrorListener { error ->
                            message(error.message)
                        }
                    ) {
                        @Throws(AuthFailureError::class)
                        override fun getParams(): Map<String, String> {
                            val params: MutableMap<String, String> = HashMap()
                            params["old_password"] = oldPassword
                            params["new_password"] = newPassword
                            params["conform_password"] = conformPassword
                            params["email"] = emailKt
                            return params
                        }
                    }

                    val queue: RequestQueue = Volley.newRequestQueue(requireContext())
                    queue.add(stringRequest)
                }
            }

            R.id.iv_arrow_back_sandi -> {
                val profileFragment = ProfileFragment()
                val fragmentManager = parentFragmentManager
                fragmentManager.beginTransaction().apply {
                    replace(
                        R.id.frame_container,
                        profileFragment,
                        ProfileFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }

    private fun handleResponse(response: String) {
        if (response.contains("Kata Sandi Lama Tidak Sama")) {
            message(response)
        } else {
            val popUpFragment = PopUpFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, popUpFragment, PopUpFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun message(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
