package com.example.kerjaparaktik.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.kerjaparaktik.R
import com.example.kerjaparaktik.profile.InfoAkunFragment
import com.example.kerjaparaktik.profile.ProfileFragment

class Logout : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_logout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnya: Button = view.findViewById(R.id.btn_ya)

        val btnbatal: ImageView = view.findViewById(R.id.logout_batal)
        btnbatal.setOnClickListener(this)

        btnya.setOnClickListener {
            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.logout_batal) {
            val btnBatal = ProfileFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, btnBatal, ProfileFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}