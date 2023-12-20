package com.example.kerjaparaktik.pendaftaran

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import com.example.kerjaparaktik.ApiInterface
import com.example.kerjaparaktik.ApiResponse
import com.example.kerjaparaktik.R
import com.github.dhaval2404.imagepicker.ImagePicker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PendaftaranFragment : Fragment() {
    private lateinit var imageViewKtp: ImageView
    private lateinit var imageViewKtm: ImageView
    private lateinit var imageViewPermohonan: ImageView
    private lateinit var buttonKtp: Button
    private lateinit var buttonKtm: Button
    private lateinit var buttonPermohonan: Button
    private var selectedImageUriKtp: Uri? = null



    private val apiInterface: ApiInterface =
        RetrofitClient.getApiClient().create(ApiInterface::class.java)

    private val IMAGE_PICKER_REQUEST_CODE_KTP = 1
    private val IMAGE_PICKER_REQUEST_CODE_KTM = 2
    private val IMAGE_PICKER_REQUEST_CODE_PERMOHONAN = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pendaftaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewKtp = view.findViewById(R.id.gambarKtp)
        imageViewKtm = view.findViewById(R.id.gambarKtm)
        imageViewPermohonan = view.findViewById(R.id.gambarPermohonan)

        buttonKtp = view.findViewById(R.id.btnktp)
        buttonKtm = view.findViewById(R.id.btnktm)
        buttonPermohonan = view.findViewById(R.id.btnpermohonan)

        buttonKtp.setOnClickListener {
            startImagePicker(IMAGE_PICKER_REQUEST_CODE_KTP)
        }
        buttonKtm.setOnClickListener {
            startImagePicker(IMAGE_PICKER_REQUEST_CODE_KTM)
        }
        buttonPermohonan.setOnClickListener {
            startImagePicker(IMAGE_PICKER_REQUEST_CODE_PERMOHONAN)
        }

        val autoMagang: AutoCompleteTextView = view.findViewById(R.id.magang)
        val autoPosisi: AutoCompleteTextView = view.findViewById(R.id.posisi)
        val btnSubmit: Button = view.findViewById(R.id.btnsubmit)

        val maganglist = listOf("PKL", "Kerja Praktik")
        val posisilist = listOf(
            "Cyber Security",
            "Mobile Developer",
            "Web Developer",
            "Game Developer",
            "Event & Community",
            "Marketing Communication"
        )


        val adapter1 = ArrayAdapter(requireContext(), R.layout.magang, maganglist)
        val adapter2 = ArrayAdapter(requireContext(), R.layout.magang, posisilist)

        // val pendaftaran
        val nama: EditText = view.findViewById(R.id.edt_nama)
        val asalKampus: EditText = view.findViewById(R.id.edt_asal_kampus)
        val noTelp: EditText = view.findViewById(R.id.edt_no_telp)
        val email: EditText = view.findViewById(R.id.edt_email)
        val magang: EditText = view.findViewById(R.id.magang)
        val posisi: EditText = view.findViewById(R.id.posisi)
        val ktp: ImageView = view.findViewById(R.id.gambarKtp)
        val ktm: ImageView = view.findViewById(R.id.gambarKtm)
        val permohonan: ImageView = view.findViewById(R.id.gambarPermohonan)


        // Adapter Untuk Drop Down Menu
        autoMagang.setAdapter(adapter1)
        autoMagang.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
            val itemSelected = adapter1.getItem(i)
            Toast.makeText(requireContext(), "$itemSelected", Toast.LENGTH_SHORT).show()
        }

        autoPosisi.setAdapter(adapter2)
        autoPosisi.onItemClickListener = AdapterView.OnItemClickListener { _, _, b, _ ->
            val itemSelected2 = adapter2.getItem(b)
            Toast.makeText(requireContext(), "$itemSelected2", Toast.LENGTH_SHORT).show()
        }

        // Adapter Button
        btnSubmit.setOnClickListener {

            val pendaftaran2 = Pendaftaran2() // Assume there is a Pendaftaran2Fragment class
            val fragmentManager = parentFragmentManager

            val namaInput = nama.text.toString()
            val asalkampusInput = asalKampus.text.toString()
            val noTelpInput = noTelp.text.toString()
            val emailInput = email.text.toString()
            val magangInput = magang.text.toString()
            val posisiInput = posisi.text.toString()
            val ktpInput = ktp.rootView.toString()
            val ktmInput = ktm.rootView.toString()
            val permohonanInput = permohonan.rootView.toString()

            val call: Call<ApiResponse> = apiInterface.performPendaftaran(namaInput, asalkampusInput, noTelpInput, emailInput, magangInput, posisiInput, ktpInput, ktmInput, permohonanInput )
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val apiResponse: ApiResponse? = response.body()
                        if (apiResponse?.getStatus() == "ok")  {
                            if (apiResponse.getResultCode() == 1) {  // Compare as String
                                fragmentManager.beginTransaction().apply {
                                    replace(
                                        R.id.frame_container,
                                        pendaftaran2,
                                        Pendaftaran2::class.java.simpleName
                                    )
                                    addToBackStack(null)
                                    commit()
                                }
                            } else {
                                Toast.makeText(context, "Semua data harus terisi...", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    // Handle failure here
                }
            })

        }

        }

        private fun startImagePicker(requestCode: Int) {
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start(requestCode)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)


            when (requestCode) {
                IMAGE_PICKER_REQUEST_CODE_KTP -> {
                    val selectedImageUriKtp = data?.data!!
                    imageViewKtp.setImageURI(selectedImageUriKtp)
                }

                IMAGE_PICKER_REQUEST_CODE_KTM -> {
                    val selectedImageUriKtm = data?.data!!
                    imageViewKtm.setImageURI(selectedImageUriKtm)
                }

                IMAGE_PICKER_REQUEST_CODE_PERMOHONAN -> {
                    val selectedImageUriPermohonan = data?.data!!
                    imageViewPermohonan.setImageURI(selectedImageUriPermohonan)
                }
                // handle other cases if needed
            }
        }

}
