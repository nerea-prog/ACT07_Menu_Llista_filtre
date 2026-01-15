package com.example.act07_menu_llista_filtre

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(
    itemView: View,
    private val onItemClick: (MyItem) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

    fun bind(item: MyItem) {
        tvTitle.text = item.title

        itemView.setOnClickListener {
            onItemClick(item)
        }
    }
}