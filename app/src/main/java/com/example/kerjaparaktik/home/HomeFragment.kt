package com.example.kerjaparaktik.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kerjaparaktik.R

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnList: TextView = view.findViewById(R.id.tv_lihatSemua)
        btnList.setOnClickListener(this)

        val ivMagang: ImageView = view.findViewById(R.id.magang)
        ivMagang.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.tv_lihatSemua){
            val listMagang= ListMagang()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,listMagang, ListMagang::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if(v?.id == R.id.magang){
            val jobDetails= MobileMagang()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,jobDetails, MobileMagang::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}