package com.example.kerjaparaktik.pendaftaran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kerjaparaktik.R
import com.google.android.gms.cast.framework.media.ImagePicker

class PendaftaranFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendaftaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.gambarKtp)
        button = view.findViewById(R.id.btnktp)

        button.setOnClickListener {
            com.github.dhaval2404.imagepicker.ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()

        }

        val autoMagang: AutoCompleteTextView = view.findViewById(R.id.magang)
        val autoPosisi: AutoCompleteTextView = view.findViewById(R.id.posisi)
        val btnSubmit: Button = view.findViewById(R.id.btnsubmit)

        val maganglist = listOf("PKL", "Kerja Praktik")
        val posisilist = listOf("Cyber Security", "Mobile Development", "Web Development", "Marketing Comunications")

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
            val targetpendaftaran = pendaftaran2()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            // Ganti fragment saat ini dengan fragment tujuan
            transaction.replace(R.id.frame_container, targetpendaftaran)

            // Tambahkan ke back stack, sehingga dapat kembali ke fragment sebelumnya
            transaction.addToBackStack(null)

            // Lakukan transaksi
            transaction.commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageView.setImageURI(data?.data)
    }
}
