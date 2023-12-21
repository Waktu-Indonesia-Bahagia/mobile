package com.example.kerjaparaktik.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kerjaparaktik.R

class NotificationAdapter (private var mList: List<NotificationData>) :
    RecyclerView.Adapter<NotificationAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.textNotif)
        val message : TextView = itemView.findViewById(R.id.textMessage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.LanguageViewHolder, position: Int) {
        holder.title.text = mList[position].title
        holder.message.text = mList[position].message
    }
    override fun getItemCount(): Int {
        return mList.size
    }

}