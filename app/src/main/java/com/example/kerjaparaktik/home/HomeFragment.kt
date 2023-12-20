package com.example.kerjaparaktik.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kerjaparaktik.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val ivmagang2: ImageView = view.findViewById(R.id.magang2)
        ivmagang2.setOnClickListener(this)

        val ivmagang3: ImageView = view.findViewById(R.id.magang3)
        ivmagang3.setOnClickListener(this)

        val ivmagang4: ImageView = view.findViewById(R.id.magang4)
        ivmagang4.setOnClickListener(this)

        val floatingBtn: FloatingActionButton = view.findViewById(R.id.fabChatbot)
        floatingBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.fabChatbot){
            val chatBot= ChatbotFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,chatBot, ChatbotFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

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
            val jobDetails1= MobileMagang()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,jobDetails1, MobileMagang::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        if(v?.id == R.id.magang2){
            val jobdetails2 = GameMagang()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, jobdetails2, GameMagang::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        if(v?.id == R.id.magang3){
            val jobdetails3 = EventComunitiyMagang()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, jobdetails3, EventComunitiyMagang::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        if(v?.id == R.id.magang4){
            val jobdetails4 = MarketingCommunications()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, jobdetails4, MarketingCommunications::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}