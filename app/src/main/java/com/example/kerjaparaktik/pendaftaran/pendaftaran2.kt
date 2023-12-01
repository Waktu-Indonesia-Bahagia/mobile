package com.example.kerjaparaktik.pendaftaran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.profile.ProfileFragment


class pendaftaran2 : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendaftaran2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnKembali: Button = view.findViewById(R.id.btn_kembali)
        btnKembali.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_kembali){
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