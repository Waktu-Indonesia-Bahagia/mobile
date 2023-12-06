package com.example.kerjaparaktik.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kerjaparaktik.R



class PengaturanFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengaturan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivBack: ImageView = view.findViewById(R.id.iv_arrow_back_pengaturan)
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.iv_arrow_back_pengaturan){
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