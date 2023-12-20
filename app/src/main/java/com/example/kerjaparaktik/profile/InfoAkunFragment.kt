package com.example.kerjaparaktik.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.kerjaparaktik.ApiInterface
import com.example.kerjaparaktik.ApiResponse
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.RetrofitClient
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [InfoAkunFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoAkunFragment : Fragment(), View.OnClickListener {
    private val apiInterface: ApiInterface = RetrofitClient.getApiClient().create(ApiInterface::class.java)
    private lateinit var btnedit: MaterialButton
    private lateinit var nama: EditText
    private lateinit var telepon: EditText
    private lateinit var kampus: EditText
    private lateinit var alamat: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ivBack: ImageView = view.findViewById(R.id.iv_arrow_back_akun)
        ivBack.setOnClickListener(this)
        setupView(view)
        setupListener()

    }

    private fun setupView(view: View) {
        nama = view.findViewById(R.id.edt_nama)
        telepon = view.findViewById(R.id.edt_notelepon)
        kampus = view.findViewById(R.id.asal_kampus)
        alamat = view.findViewById(R.id.alamat)
        btnedit = view.findViewById(R.id.edit_data)
    }

    private fun setupListener() {
        btnedit.setOnClickListener {
            val namaInput = nama.text.toString()
            val teleponInput = telepon.text.toString()
            val kampusInput = kampus.text.toString()
            val alamatInput = alamat.text.toString()


            val call: Call<ApiResponse> =
                apiInterface.PerfomEdit(namaInput, teleponInput, kampusInput, alamatInput)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val apiResponse: ApiResponse? = response.body()
                        if (apiResponse?.getStatus() == "OK") {
                            if (apiResponse.getResultCode() == 1) {
                                Toast.makeText(
                                    requireActivity(),
                                    "Sucess Updated",
                                    Toast.LENGTH_SHORT
                                ).show()
                                requireActivity().
                                onBackPressed()
                                return
                            } else {
                                Toast.makeText(
                                    requireActivity(),
                                    "Sucess Updated ! ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                requireActivity(),
                                "Updated Failed ! ",
                                Toast.LENGTH_SHORT
                            ).show()
                            requireActivity().
                                    onBackPressed()
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    //handle
                }
            })
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.iv_arrow_back_akun) {
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
       /* btnedit.setOnClickListener{
            val namaInput = nama.text.toString()
            val teleponInput = telepon.text.toString()
            val kampusInput = kampus.text.toString()
            val alamatInput = alamat.text.toString()

            val call: Call<ApiResponse> = apiInterface.PerfomEdit(namaInput,teleponInput,kampusInput,alamatInput)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if(response.isSuccessful){
                        val apiResponse: ApiResponse? = response.body()
                        if(apiResponse?.getStatus() == "OK"){
                            if (apiResponse.getResultCode() == 1) {
                                Toast.makeText(requireActivity(), "Sucess Updated", Toast.LENGTH_SHORT).show()
                                requireActivity().onBackPressed()
                            } else {
                                Toast.makeText(requireActivity(), "Updated Failed ! ", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(requireActivity(), "Updated Failed ! ", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    //handle
                }
            })
        }
    }*/
