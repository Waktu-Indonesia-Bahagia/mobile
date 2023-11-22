package com.example.kerjaparaktik.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.kerjaparaktik.R

class UbahSandiFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
        if(v?.id == R.id.btn_ubah){
            val popUpFragment= PopUpFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,popUpFragment, PopUpFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if(v?.id == R.id.iv_arrow_back_sandi){
            val profileFragment= ProfileFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,profileFragment, ProfileFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}