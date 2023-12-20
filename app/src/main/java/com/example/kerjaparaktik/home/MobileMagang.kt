package com.example.kerjaparaktik.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.pendaftaran.PendaftaranFragment


class MobileMagang : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile_magang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDaftar: Button = view.findViewById(R.id.btnDaftar)
        btnDaftar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btnDaftar){
            val pendaftaranFragment= PendaftaranFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,pendaftaranFragment, PendaftaranFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}