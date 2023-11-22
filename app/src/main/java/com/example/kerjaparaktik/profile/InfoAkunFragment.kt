package com.example.kerjaparaktik.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kerjaparaktik.R

/**
 * A simple [Fragment] subclass.
 * Use the [InfoAkunFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoAkunFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ivBack: ImageView = view.findViewById(R.id.iv_arrow_back_akun)
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.iv_arrow_back_akun){
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