package com.example.kerjaparaktik.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.pendaftaran.PendaftaranFragment


class MarketingCommunications : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marketing_communications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dafta_Mc : Button = view.findViewById(R.id.daftar_MC)
        dafta_Mc.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.daftar_MC){
            val daftarmc = PendaftaranFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, daftarmc, PendaftaranFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}