package com.example.kerjaparaktik.pendaftaran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
import com.example.kerjaparaktik.MainActivity
import com.example.kerjaparaktik.R


class PendaftaranFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendaftaran, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val autoMagang: AutoCompleteTextView = view.findViewById(R.id.magang)
        val autoPosisi: AutoCompleteTextView = view.findViewById(R.id.posisi)

        val maganglist = listOf("PKL","Kerja Praktik")
        val posisilist = listOf("Cyber Security")

        val adapter1 = ArrayAdapter(requireContext(),R.layout.magang,maganglist)
        val adapter2 = ArrayAdapter(requireContext(),R.layout.magang,posisilist)


        autoMagang.setAdapter(adapter1)
        autoMagang.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireContext(), "$itemSelected", Toast.LENGTH_SHORT).show()
        }

        autoMagang.setAdapter(adapter2)
        autoMagang.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, b, l ->
            val itemSelected = adapterView.getItemAtPosition(b)
            Toast.makeText(requireContext(), "$itemSelected", Toast.LENGTH_SHORT).show()
        }

//        // Adapter untuk Spinner
//        val adapter = ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.magang_options,
//            android.R.layout.simple_spinner_item
//        )
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        // Set adapter ke Spinner
//        spinnerMagang.adapter = adapter
//
//        val adapterPosisi = ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.posisi_options,
//            android.R.layout.simple_spinner_item
//        )
//        adapterPosisi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinnerPosisi.adapter = adapterPosisi
    }
}