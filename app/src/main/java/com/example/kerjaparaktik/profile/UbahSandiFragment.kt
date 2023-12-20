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
import com.example.kerjaparaktik.ApiInterface
import com.example.kerjaparaktik.ApiResponse
import com.example.kerjaparaktik.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UbahSandiFragment : Fragment(), View.OnClickListener {
    private val apiInterface: ApiInterface = RetrofitClient.getApiClient().create(ApiInterface::class.java)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val value = arguments?.getString("email", "default_value")
        return inflater.inflate(R.layout.fragment_ubah_sandi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnUbah: Button = view.findViewById(R.id.btn_ubah)
        btnUbah.setOnClickListener(this)

        val ivBack: ImageView = view.findViewById(R.id.iv_arrow_back_sandi)
        ivBack.setOnClickListener(this)



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

                performPasswordChange(oldPassword, newPassword, conformPassword)
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

    private fun performPasswordChange(oldPassword: String, newPassword: String, conformPassword: String) {
        val call: Call<ApiResponse> = apiInterface.performResetPassword(oldPassword, newPassword, conformPassword)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    handleResponse(response.body()?.getStatus())
                } else {
                    showCustomToast("Ubah Kata Sandi Gagal!")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                showCustomToast("Network Error: ${t.message}")
            }
        })
    }



    fun showCustomToast(message: String) {
        val context = requireContext() // Mendapatkan konteks dari fragment
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleResponse(response: String?) {
        if (!response.isNullOrEmpty()) {
            if (response == "Kata Sandi berhasil diubah!") {
                println("Success")
                showPopUpFragment()

            } else {
                message(response)
            }
        } else {
            message("Error: Response body is null or empty")
        }
    }


    private fun showPopUpFragment() {
        val popUpFragment = PopUpFragment()
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.frame_container, popUpFragment, PopUpFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }





    private fun message(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
