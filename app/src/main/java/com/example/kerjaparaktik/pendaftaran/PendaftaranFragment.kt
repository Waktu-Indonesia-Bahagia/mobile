package com.example.kerjaparaktik.pendaftaran

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kerjaparaktik.R
import com.github.dhaval2404.imagepicker.ImagePicker

class PendaftaranFragment : Fragment() {
    private lateinit var imageViewKtp: ImageView
    private lateinit var imageViewKtm: ImageView
    private lateinit var imageViewPermohonan: ImageView
    private lateinit var buttonKtp: Button
    private lateinit var buttonKtm: Button
    private lateinit var buttonPermohonan: Button

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
        val posisilist = listOf("Cyber Security", "Mobile Developer", "Web Developer","Game Developer","Event & Community", "Marketing Communication")


        val adapter1 = ArrayAdapter(requireContext(), R.layout.magang, maganglist)
        val adapter2 = ArrayAdapter(requireContext(), R.layout.magang, posisilist)

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
            val targetpendaftaran = pendaftaran2() // Assume there is a Pendaftaran2Fragment class
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            // Ganti fragment saat ini dengan fragment tujuan
            transaction.replace(R.id.frame_container, targetpendaftaran)

            // Tambahkan ke back stack, sehingga dapat kembali ke fragment sebelumnya
            transaction.addToBackStack(null)

            // Lakukan transaksi
            transaction.commit()
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
        val selectedImageUri: Uri? = data?.data

        when (requestCode) {
            IMAGE_PICKER_REQUEST_CODE_KTP -> {
                imageViewKtp.setImageURI(selectedImageUri)
            }
            IMAGE_PICKER_REQUEST_CODE_KTM -> {
                imageViewKtm.setImageURI(selectedImageUri)
            }
            IMAGE_PICKER_REQUEST_CODE_PERMOHONAN -> {
                imageViewPermohonan.setImageURI(selectedImageUri)
            }
            // handle other cases if needed
        }
    }
}
