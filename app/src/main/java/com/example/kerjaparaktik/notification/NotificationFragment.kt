package com.example.kerjaparaktik.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kerjaparaktik.R

class NotificationFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<NotificationData>()
    //    private lateinit var btnfilter: ImageButton
    private lateinit var adapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

//        btnfilter = view.findViewById(R.id.filter)
//        btnfilter.setOnClickListener(this)

        recyclerView = view.findViewById(R.id.recyclerViewNotifikasi)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        adapter = NotificationAdapter(mList)
        addDataToList()
        recyclerView.adapter = adapter

        return view
    }

    private fun addDataToList() {
        mList.add(NotificationData("Selamat datang</b> di Aplikasi Kami, Aplikasi Kami ini bertujuan bagi Mahasiswa yang ingin kerja praktik." ,""))
        mList.add(NotificationData("Pendaftaran","</b> Anda sedang diproses oleh Pihak Instansi."))
        mList.add(NotificationData("Profile","</b> Anda berhasil diubah."))
        mList.add(NotificationData("Selamat","</b> Anda berhasil diterima oleh Pihak Instansi."))
    }

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.filter -> {
//                // Tambahkan aksi yang sesuai di sini
//                // contoh: buka fragment/filter, tampilkan dialog, atau pindah ke halaman pengaturan
//            }
//        }
//    }
}