package com.example.kerjaparaktik.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kerjaparaktik.R


class ListMagang : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_magang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivMagang1: ImageView = view.findViewById(R.id.pmagang)
        ivMagang1.setOnClickListener(this)

        val ivBack: ImageView = view.findViewById(R.id.iv_back)
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.pmagang){
            val jobDetails= MobileMagang()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,jobDetails, MobileMagang::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        if(v?.id == R.id.iv_back){
            val homeFragment= HomeFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,homeFragment, HomeFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

    }


}