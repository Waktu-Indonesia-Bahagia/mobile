package com.example.kerjaparaktik.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.pendaftaran.PendaftaranFragment


class GameMagang : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_magang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btndaftar: Button = view.findViewById(R.id.daftar_game)
        btndaftar.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.daftar_game){
            val daftar_game= PendaftaranFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,daftar_game, PendaftaranFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

    }
}