package com.example.kerjaparaktik.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kerjaparaktik.R
import org.w3c.dom.Text

class ProfileFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvUser: TextView = view.findViewById(R.id.tv_user)
        tvUser.setOnClickListener(this)

        val ivUser: ImageView = view.findViewById(R.id.iv_user)
        ivUser.setOnClickListener(this)

        val tvLock: TextView = view.findViewById(R.id.tv_lock)
        tvLock.setOnClickListener(this)

        val ivLock: ImageView = view.findViewById(R.id.iv_lock)
        ivLock.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.tv_user || v?.id == R.id.iv_user){
            val infoAkunFragment= InfoAkunFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,infoAkunFragment, InfoAkunFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if(v?.id == R.id.tv_lock || v?.id == R.id.iv_lock){
            val ubahSandiFragment= UbahSandiFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container,ubahSandiFragment, UbahSandiFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

    }
}