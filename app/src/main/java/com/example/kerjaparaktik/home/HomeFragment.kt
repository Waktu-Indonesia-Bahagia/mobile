package com.example.kerjaparaktik.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kerjaparaktik.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var floatingButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        floatingButton = view.findViewById(R.id.fabChatbot)
        floatingButton.setOnClickListener {
            navigateToFragment(ChatbotFragment())
            floatingButton.visibility = View.GONE
        }

        val btnList: TextView = view.findViewById(R.id.tv_lihatSemua)
        btnList.setOnClickListener(this)

        val ivMagang: ImageView = view.findViewById(R.id.magang)
        ivMagang.setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_lihatSemua -> navigateToFragment(ListMagang())
            R.id.magang -> navigateToFragment(MobileMagang())
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.frame_container, fragment, fragment::class.java.simpleName)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
